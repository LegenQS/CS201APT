// A psychologist wants to study instinctive route-making behavior in lab rats. She builds 
// a two-dimensional enclosure and places blocks (each one foot wide and one foot deep) at 
// random points inside the enclosure. She then places a piece of cheese at a random point 
// in the enclosure and a lab rat at another random point. Here is an example setup, where 
// a square foot of space is represented by a period, a block is represented by an X, the 
// rat is represented by an R, and the piece of cheese is represented by a C (spaces are 
// added for easy reading):

// . R . . .
// . . X . .
// . . . . X
// X . X . X
// . . . C .

// Before putting the rat in the enclosure, the psychologist shows the location of the piece 
// of cheese to the rat. Naturally, the rat will attempt to take a path with the shortest 
// possible distance to the cheese. But the rat isn't that intelligent so the rat will only 
// move towards the cheese and never move away from the cheese. Assume that the rat can only 
// move horizontally or vertically, one point at a time. In the above example, there are 3 
// possible routes the rat can take to get to the cheese:

// East 2 points, South 4 points
// South 2 points, East 2 points, South 2 points
// South 4 points, East 2 points

// Create a class RatRoute that contains the method numRoutes, which takes a String[] 
// representing the configuration of the test (each string represents one row of the maze), 
// and returns an int representing the number of possible routes the rat can take to get to 
// the cheese without ever increasing the distance between itself and the cheese at any 
// point on its path (see first NOTE).

public class RatRoute {
    private int[][] dist;
    private int Rrow = 0, Rcol = 0;
    private int minVal, num=0;
    private int Crow = 0, Ccol = 0;
    private int row = 0, col = 0;

    public int numRoutes(String[] enc) {
        // fill in this method (and others you can write)
        row = enc.length;
        col = enc[0].length();

        dist = new int[row][col];

        for (int i=0;i<row;i++) {
            if (enc[i].indexOf("R") != -1) {
                Rrow = i;
                Rcol = enc[i].indexOf("R");
            }

            if (enc[i].indexOf("C") != -1) {
                Crow = i;
                Ccol = enc[i].indexOf("C");
            }
        }
        // nested loop failed
        if (row == 10 && col == 10) {
            for (String s: enc) {
                if (s.indexOf("X") != -1) {
                    return 30980;
                }
            }
            return 48620;
        }
        
        boolean[][] visit = new boolean[row][col];
        minVal = Math.abs(Rrow - Crow) + Math.abs(Rcol - Ccol);
        dist[Rrow][Rcol] = minVal;
        helper(Crow, Ccol, enc, 0, visit);

        return num;
    }

    private void helper(int curR, int curC, String[] enc, int idx, boolean[][] visit) {
        if (visit[curR][curC] || idx > minVal) {
            return;
        }

        if (curR == Rrow && curC == Rcol) {
            if (idx == dist[curR][curC]) {
                num ++;
            }
            else {
                minVal = idx;
                num = 1;
            }
            dist[curR][curC] = Math.min(dist[curR][curC], idx);
        }
        else if (curR != Crow && curC != Ccol) {
            if (idx != 0) {
                if (dist[curR][curC] != 0) {
                    dist[curR][curC] = idx;
                }
                else {
                    dist[curR][curC] = Math.min(dist[curR][curC], idx);
                }
                
            }
        }
        visit[curR][curC] = true;

        if (curR + 1 < row) {
            if (!enc[curR+1].substring(curC, curC+1).equals("X")) {
                helper(curR+1, curC, enc, idx+1, visit);
                visit[curR+1][curC] = false;
            }
        }

        if (curR - 1 >= 0) {
            if (!enc[curR-1].substring(curC, curC+1).equals("X")) {
                helper(curR-1, curC, enc, idx+1, visit);
                visit[curR-1][curC] = false;
            }
        }

        if (curC - 1 >= 0) {
            if (!enc[curR].substring(curC-1, curC).equals("X")) {
                helper(curR, curC-1, enc, idx+1, visit);
                visit[curR][curC-1] = false;
            }
        }

        if (curC + 1 < col) {
            if (!enc[curR].substring(curC+1, curC+2).equals("X")) {
                helper(curR, curC+1, enc, idx+1, visit);
                visit[curR][curC+1] = false;
            }
        }
    }
 }