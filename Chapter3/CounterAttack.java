// Count how many times each element of words occurs as a 
// white-space delimited string in parameter str. Return 
// the number of occurrences in an int[] so that the number 
// of times that words[k] occurs is given by the kth value 
// in the returned array.

import java.util.HashMap;

public class CounterAttack {
    public int[] analyze(String str, String[] words) {
        // change this code
        HashMap<String, Integer> result = new HashMap<>();
        for (String s: str.split(" ")) {
            if (result.containsKey(s)) {
                result.replace(s, result.get(s) + 1);
            }
            else {
                result.put(s, 1);
            }
        }
        
        int[] count = new int[words.length];
        int idx = 0;
        for (String word: words) {
            if (result.containsKey(word)) {
                count[idx] = result.get(word);
            }
            else {
                count[idx] = 0;
            }
            idx += 1;
        }

        return count;
    }
}