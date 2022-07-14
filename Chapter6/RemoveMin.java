// Write a method remove that removes the node with the minimal 
// value from the linked-list parameter list, returning a linked 
// list that has one less node than list since the minimal node 
// is removed. The other nodes in the returned list should be in 
// the same order as they are in parameter list.

// You can create a new list without the minimal value rather 
// than removing the minimal node, the tester won't differentiate 
// between changing list or returning a new list with one fewer 
// node than list when the minimal node is not present.


public class RemoveMin {
    public ListNode remove (ListNode list) {
        // replace statement below with code you write
        if (list == null || list.next == null) {
            return null;
        }

        ListNode dummy_head = new ListNode(0, list);
        ListNode pre = null;
        ListNode nxt = null;
        ListNode last = null;
        int val = 65535;
        while (list != null) {
            if (val > list.info) {
                pre = last;
                nxt = list.next;
                val = list.info;
            }
            last = list;
            list = list.next;
        }

        if (pre == null) {
            return nxt;
        }
        else if (nxt == null) {
            pre.next = null;
        }
        else {
            pre.next = nxt;
        }
        return dummy_head.next;
        
    }
}