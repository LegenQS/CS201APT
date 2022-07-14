// Write a method move that moves the last node of a linked 
// list to the front of the list, leaving the order of the 
// other nodes unchanged.

// You can create a new list with new nodes or you can simply 
// move the last node of the ListNode parameter to the front 
// and return the modified list.

public class ListLastFirst {
    public ListNode move(ListNode list) {
        // replace statement below with code you write
        ListNode dummy_head = new ListNode(0, list);
        ListNode pre = null;
        while (list != null && list.next != null) {
            pre = list;
            list = list.next;
        }
        if (pre == null) {
            return list;
        }
        list.next = dummy_head.next;
        pre.next = null;

        return list;

    }
}