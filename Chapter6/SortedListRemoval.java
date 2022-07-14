// Challenge

// Write method uniqify to remove all duplicate values from a 
// sorted linked list of integer values, leaving the unique 
// values occurring once and in order. For example, the list 
// represented by [1,1,2,3,3,3,4] would be changed to [1,2,3,4]. 
// You should remove nodes and relink nodes rather than creating 
// a new list.


public class SortedListRemoval {
    public ListNode uniqify(ListNode list){
        // write code here
        if (list == null) {
            return list;
        }
        ListNode dummy_head = new ListNode(0, list);
        ListNode pre = null;
        int val=-65535;
        while (list.next != null) {
            if (val != list.info) {
                val = list.info;
                if (pre != null) {
                    pre.next = list;
                    pre = list;
                }
                else {
                    pre = list;
                }  
            }
            list = list.next;
        }

        if (val == list.info) {
            pre.next = null;
        }

        return dummy_head.next;
    }
}