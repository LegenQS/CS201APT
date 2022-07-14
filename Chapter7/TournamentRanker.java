// Challenge

// A single elimination tournament consists of several rounds. In the first 
// round, each competitor plays against one other competitor and the loser 
// is eliminated. In the second round, each competitor that was not 
// eliminated in the first round plays against another such competitor, and 
// the loser is again eliminated. This process is repeated, eliminating half 
// of the remaining competitors each round, until precisely one competitor 
// remains. This competitor is declared the champion.

// In practice, one is often interested in ranking all the competitors in a 
// tournament, not just the champion. Here is one way of doing this:

// If competitor A won more games than competitor B did in the tournament, 
// then A should be ranked higher than B.

// If competitor A and competitor B won the same number of games in the 
// tournament, recursively compare the ranks of the competitor C that 
// eliminated A and the competitor D that eliminated B. Then, A should be 
// ranked above B if and only if C is ranked above D.

// The intuition behind the second rule is that losing to a good competitor 
// is better than losing to a bad competitor.

// You must implement this scheme for ranking the competitors in a single 
// elimination tournament. You will be given a String[] names and a String[] 
// lostTo. The former argument gives the names of the competitors in a 
// tournament, and the latter argument describes if and how each competitor 
// was eliminated. Specifically, the ith element of lostTo will be the name 
// of the competitor that beat the ith competitor in names, or it will be 
// "" if that competitor never lost. You should return a String[] giving 
// the names of the competitors, sorted from highest rank to lowest rank 
// as described above.

import java.util.*;
import java.util.Map.Entry;

public class TournamentRanker  {
    
    public String[] rankTeams(String[] names, String[] lostTo) {
        // fill in code here
        String[] result = new String[names.length];
        int pos = 0;
        Map<String, Integer> score = new HashMap<>();
        Map<String, String> lost = new HashMap<>();

        for (int i=0;i<names.length;i++) {
            if (!score.containsKey(names[i])) {
                score.put(names[i], 0);
            }

            if (lostTo[i].equals("")) {
                score.replace(names[i], score.get(names[i]) + 1);
            }
            else {
                score.put(lostTo[i], score.getOrDefault(lostTo[i], 0) + 1);
                lost.put(names[i], lostTo[i]);
            }
        }

        List<Map.Entry<String, Integer>> res = new ArrayList<>(score.entrySet());
        Collections.sort(res, new Comparator<Map.Entry<String, Integer>>() {

            @Override
            public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
                if (o1.getValue() != o2.getValue()) {
                    return o2.getValue() - o1.getValue();
                }
                else {
                    String pre_o1 = o1.getKey();
                    String pre_o2 = o2.getKey();
                    while (pre_o1 != null && pre_o2 != null) {    
                        pre_o1 = lost.get(pre_o1);
                        pre_o2 = lost.get(pre_o2);
                        if (score.get(pre_o1) != score.get(pre_o2)) {
                            return score.get(pre_o2) - score.get(pre_o1);
                        }
                    }
                    return 0;
                }
            } 
        });

        for (Map.Entry<String, Integer> s: res) {
            result[pos++] = s.getKey();
        }

        return result;
    }
 }