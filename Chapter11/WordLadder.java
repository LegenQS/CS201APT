import java.util.*;

public class WordLadder {
    
    public String ladderExists(String[] words,
            String from, String to) {
        // fill in code here

        ArrayList<String> round = new ArrayList<>();
        helper(from, -1, words, round, to);
        
        for (String s : round) {
            System.out.println(s);
        }
        if (round.size() != 0) {
            return "ladder";
        }
        return "none";
    }

    public boolean helper(String s, int idx, String[] words, ArrayList<String> round, String to) {
        if (isSimilar(s, to) && round.size() != 0) {
            return true;
        }

        for (int i=0;i<words.length;i++) {
            if (i != idx) {
                if (isSimilar(words[i], s) && !round.contains(words[i])) {
                    round.add(words[i]);
                    if (helper(words[i], i, words, round, to)) {
                        return true;
                    }
                    round.remove(words[i]);
                }
            }
        }
        return false;
    }

    public boolean isSimilar(String a, String b) {
        if (a.length() != b.length()) return false;
        
        int num = 0;
        for (int i=0;i<a.length();i++) {
            if (!a.substring(i,i+1).equals(b.substring(i,i+1))) {
                num += 1;
            }
            if (num > 1) {
                return false;
            }
        }

        if (num == 0) {
            return false;
        }
        return true;
    }
}