// Write a method bigify that "doubles" a list so that the list 
// [1,2,3] becomes [1,1,2,2,3,3]. For every node Ni in the list 
// passed a parameter.a new node is added following Ni holding 
// the same value as N_i and pointing to N_{i+1}. The last node in 
// the original list points at a new last node with the same value.

// You can create a new list with new nodes or you can simply 
// add N nodes to an N node list that's passed as a parameter.

public class DoubleList {
    public ListNode bigify (ListNode list){
        // replace statement below with code you write
        ListNode dummy_head = new ListNode(0, list);
        ListNode nxt = null;
        while (list != null) {
            nxt = list.next;

            list.next = new ListNode(list.info);
            list = list.next;

            list.next = nxt;
            list = list.next;
        }
        return dummy_head.next;
    }
}