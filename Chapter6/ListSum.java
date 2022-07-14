// Write a method sum that returns the sum of the values 
// greater than thresh in its list parameter, a linked 
// list of int values;

public class ListSum {
    public int sum(ListNode list, int thresh) {
        // replace statement below with code you write
        int res = 0;

        while (list!=null) {
            if (list.info > thresh) {
                res += list.info;
            }
                
            list = list.next;
        }
        return res;
    }
}