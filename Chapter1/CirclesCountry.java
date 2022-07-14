// Challenge

// Circles Country is a country that contains several circular-shaped 
// districts. Some districts may be situated inside other districts, 
// but their borders do not intersect or touch. Qatam is a resident of 
// Circles Country. When he travels between two locations, he always 
// tries to cross the fewest number of district borders as possible 
// because crossing borders is usually a laborious task.

// Imagine Circles Country as an infinite plane. You are given int[] x 
// and int[] y and int[] r, where (x[i],y[i]) are the coordinates of 
// the i-th district's center and r[i] is its radius. Qatam is currently 
// at point (x1,y1) and he needs to get to point (x2,y2). Neither of 
// these points lies on a district border. Return the minimal number of 
// district borders he must cross to get to his destination.

public class CirclesCountry {
    public int leastBorders(int[] x, int[] y, int[] r, 
                            int x1, int y1, int x2, int y2) {
        // you write code here

        int minVal =  0;
        double dist1, dist2;

        for(int i=0;i<x.length;i++) {
            dist1 = Math.sqrt(Math.pow(x1 - x[i], 2) + Math.pow(y1 - y[i], 2));
            dist2 = Math.sqrt(Math.pow(x2 - x[i], 2) + Math.pow(y2 - y[i], 2));

            if (!(dist1 < r[i] && dist2 < r[i]) && !(dist1 > r[i] && dist2 > r[i])) {
                minVal += 1;
            }
        }
        return minVal;
    }
}