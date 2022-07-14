// Two phrases are anagrams if they are permutations of each other, 
// ignoring spaces and capitalization. For example, "Aaagmnrs" is 
// an anagram of "anagrams", and "TopCoder" is an anagram of "Drop 
// Cote". Given a String[] phrases, remove each phrase that is an 
// anagram of an earlier phrase, and return the remaining phrases 
// in their original order.

// In writing code you'll need to return a new array whose elements 
// aren't anagrams of each other.

import java.util.*;

public class Aaagmnrs {
    public String[] anagrams(String[] list) {
        // replace this with your code
        HashSet<String> hash = new HashSet<>();
        char[] c;
        String mid;

        ArrayList<String> res = new ArrayList<>();
        for (String s: list) {
            c = s.toLowerCase().replace(" ", "").toCharArray();
            Arrays.sort(c);
            mid = String.copyValueOf(c);
            if(!hash.contains(mid)) {

                hash.add(mid);
                res.add(s);
            }
        }
        String[] val = new String[res.size()];
        res.toArray(val);

        return val;
    }
}