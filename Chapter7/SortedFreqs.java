// The frequency with which data occurs is sometimes an important statistic. 
// In this problem you'll determine how frequently strings occur and return 
// an array representing the frequencies of each different/unique string. 
// The array returned contains as many frequencies as there are unique 
// strings. The returned frequencies represent an alphabetic/lexicographic 
// ordering of the unique words, so the first frequency is how many times 
// the alphabetically first word occurs and the last frequency is the number 
// of times the alphabetically last word occurs.


import java.util.*;
import java.util.Map.Entry;

public class SortedFreqs {
    public int[] freqs(String[] data) {
        // fill in code here
        Map<String, Integer> count = new HashMap<>();

        for (String s: data) {
            count.put(s, count.getOrDefault(s, 0) + 1);
        }
        
        ArrayList<Map.Entry<String, Integer>> res = new ArrayList<>(count.entrySet());
        Collections.sort(res, new Comparator<Map.Entry<String, Integer>>() {

            @Override
            public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
                return o1.getKey().compareTo(o2.getKey());
            }
            
        });
        int[] result = new int[count.size()];
        int idx = 0;
        for (Map.Entry<String, Integer> s: res) {
            result[idx++] = s.getValue();
        }

        return result;
    }
 }

 // Can also be solved by TreeMap
 