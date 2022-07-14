// Write a method create that creates a linked-list of nodes whose 
// values are the lengths of the unique strings in words when 
// considered in alphabetical order.

import java.util.TreeSet;

public class AlphaLength {
    public ListNode create (String[] words) {
        TreeSet<String> tree = new TreeSet<>();
        for(String a: words) {
            tree.add(a);
        } 
       
        ListNode n1 = new ListNode(0);
        ListNode n2 = n1;

        for(String s: tree){
            n2.next = new ListNode(s.length());
            n2 = n2.next;
        }

        return n1.next;
    }
}
