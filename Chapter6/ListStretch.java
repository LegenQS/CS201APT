// Write a method stretch that stretches a linked list of integers 
// by a specified integer value amount, so that each node of the 
// list parameter is represented by amount copies of the node in 
// the list that's returned.

public class ListStretch {
    public ListNode stretch (ListNode list, int amount){
        // replace statement below with code you write
        ListNode dummy_head = new ListNode(0, list);
        ListNode nxt = null;
        while (list != null) {
            nxt = list.next;
            for (int i=1;i<amount;i++) {
                list.next = null;
                list.next = new ListNode(list.info);
                list = list.next;
            }
            list.next = nxt;
            list = list.next;
        }
        return dummy_head.next;
    }
}