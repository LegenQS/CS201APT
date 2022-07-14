// Challenge O(n), T(max length of words)

// Two strings have a letter in common if it appears in both strings. 
// The position of letter is not important for it to be counted as 
// common. Once a particular letter is counted as in common, it cannot 
// be counted again. For example, an o appearing twice in one word 
// but only once in the other counts only as one letter in common. 
// However, an o appearing twice both words counts as two letters 
// in common.

// Write a function that takes two strings and returns the number of 
// letters they have in common.

// Hint: you will need some way to avoid counting a letter more than 
// once if it is in common to both words. Recall that strings are immutable.

import java.util.HashMap;

public class Common {
    public int count (String a, String b) {
       int num = 0;
       String idx;
        HashMap<String, Integer> result = new HashMap<>();
        for (int i=0;i<a.length();i++) {
            idx = a.substring(i,i+1);
            if (result.containsKey(idx)){
                result.replace(idx, result.get(idx)+1);
            }
            else {
                result.put(idx, 1);
            }
        }

        for (int i=0;i<b.length();i++) {
            idx = b.substring(i,i+1);
            if (result.containsKey(idx)) {
                if (result.get(idx) > 0) {
                    num += 1;
                    result.replace(idx, result.get(idx) - 1);
                }
            }
        }

        return num;
    }
 }