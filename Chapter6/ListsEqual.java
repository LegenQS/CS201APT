// Write a method equal that returns 1 if its two linked list 
// parameters are equal, and returns 0 if they are not equal.

// Two linked lists are considered equal if they have the same 
// number of nodes and each node in the ith position in list a1 
// contains the same value is that contained in the ithe node 
// of a2


public class ListsEqual {
    public int equal (ListNode a1, ListNode a2) {
        // replace statement below with code you write

        while (a1 != null && a2 != null) {
            if (a1.info != a2.info) {
                return 0;
            }
            a1 = a1.next;
            a2 = a2.next;
        }
        
        if (a1 != null || a2 != null) {
            return 0;
        }


        return 1;
    }
}