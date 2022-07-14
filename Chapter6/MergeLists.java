// Challenge

// Write method weave that takes two lists with the same number of nodes 
// and weaves them together alternating one node from list a and one 
// node from list b, returning the weaved-together list.

// The weaved-list always starts with the first node/value from a, then 
// chooses the next value from list b, and alternates, choosing successive 
// values alternatively from each list. The last value in the returned 
// list will always be the last value from b.

// For example, if a = [1,3,5,7] and b = [2,4,6,8], then the call weave(a,b) 
// returns [1,2,3,4,5,6,7,8].

// You can create new nodes are weave together existing nodes.

public class MergeLists {
    public ListNode weave (ListNode a, ListNode b) {
        // replace statement below with code you write
        ListNode dummy_head = new ListNode(0);
        ListNode res = dummy_head;
        boolean sign = false;
        
        while (a != null || b != null) {
            if (!sign) {
                res.next = new ListNode(a.info);
                res = res.next;
                a = a.next;
                sign = true;
            }
            else {
                res.next = new ListNode(b.info);
                res = res.next;
                b = b.next;
                sign = false;
            }

        }
        return dummy_head.next;
    }
}