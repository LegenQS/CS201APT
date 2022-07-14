// The phrases even keeled, odd job, and total eclipse might come 
// to mind as you solve this APT. Given an array of int values, 
// return the sum of those values that are at odd indexes, even 
// indexes, or every index depending on whether the value of the 
// String stype is "odd", "even", or "all", respectively. 

public class Totality {
    public int sum(int[] a, String stype) {
        // you add code here
        int val = 0;
        switch (stype) {
            case "even":
                for(int i=0;i<a.length;i+=2) {
                    val += a[i];
                }
                break;
            case "odd":
                for(int i=1;i<a.length;i+=2) {
                    val += a[i];
                }
                break;
            default:
                for(int i: a) {
                    val += i;
                }
                    
            }
        return val;
    }
}
