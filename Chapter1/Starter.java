// Determine how many unique words in an array of words start with 
// a specified letter. Write a method that determines how many 
// different strings in words have a first letter equal to first.

import java.util.HashSet;

public class Starter {
    public int begins(String[] words, String first) {
        // replace this code
        if (words.length == 0) {
            return 0;
        }

        HashSet<String> result = new HashSet<>();
        int num = 0;
        for (String s: words) {
            if (s.startsWith(first)){
                if (!result.contains(s)) {
                    num += 1;
                    result.add(s);
                }
            }
        }
        return num;
    }
}