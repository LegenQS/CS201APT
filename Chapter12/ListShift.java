// Write method shift that returns a new linked-list by shifting nodes 
// in parameter start less than or equal to key to the front. All nodes 
// whose info field is greater than key appear at the front of the 
// returned list, in the same order as the nodes are in start. Nodes 
// whose info field is less than or equal to key appear after all nodes 
// shifted to the front, in the same order that these nodes are in start. 
// See examples for details.

// You can make new nodes or use the nodes in parameter start.

public class ListShift {
    public ListNode shift(ListNode start, int key) {
        // write code here 

        ListNode dummy_head = new ListNode(0, start);
        ListNode larger = new ListNode(0);
        ListNode mid = larger;
        ListNode pre = null;

        while (start != null) {
            if (start.info > key) {
                mid.next = start;
                mid = mid.next;

                if (pre == null) {
                    dummy_head.next = start.next;
                    start.next = null;
                    start = dummy_head.next;
                }
                else {
                    pre.next = start.next;
                    start.next = null;
                    start = pre.next;
                }
            }
            else {
                pre = start;
                start = start.next;
            }

        }

        if (larger.next == null) {
            return dummy_head.next;
        }

        mid.next = dummy_head.next;

        return larger.next;
    }
}