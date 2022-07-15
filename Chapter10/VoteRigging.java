import java.util.*;

public class VoteRigging {
    public int minimumVotes(int[] votes) {
        // fill in code here
        if (votes.length == 1) {
            return 0;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(11,new Comparator<Integer>(){ 
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        int res = 0;
        int val;

        for (int i=1;i<votes.length;i++) {
            maxHeap.add(votes[i]);
        }

        while (true) {
            val = maxHeap.poll();
            if (val >= votes[0]) {
                res += 1;
                votes[0] += 1;
            }
            else {
                break;
            }
            maxHeap.add(val - 1);
        }

        return res;
    }
}