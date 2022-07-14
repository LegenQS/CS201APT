import java.util.ArrayList;
import java.util.Collections;

public class SortedListInsert {
    public ListNode insertArray(ListNode list, int[] values) {
      ArrayList<Integer> val =  new ArrayList<>();
      ListNode head = null;
      ListNode pre = null;
      ListNode nex = null;
      while (list != null){
        val.add(list.info);
        list = list.next;
      }

      for(int value : values){
        val.add(value);
      }

      Collections.sort(val);   

      for(int i=0;i<val.size();i++){
        if (i==0){
          head = new ListNode(val.get(i));
          pre = head;
        }
        else {
          nex = new ListNode(val.get(i));
          pre.next = nex;
          pre = nex;
        }
      }

      return head;
    }
    


  }