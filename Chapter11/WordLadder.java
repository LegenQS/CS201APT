// A word ladder is a sequence of words in which each word can be transformed 
// into the next word by changing one letter. For example, the word ladder 
// below changes 'lot' to 'log'.

//    lot dot dog log

// This is not the shortest word-ladder between 'lot' and 'log' since the 
// former can be immediately changed to the latter yielding a word ladder of 
// length two:

//   lot log

// The first and last words in a word ladder are the anchor rungs of the 
// ladder. Any other words are interior rungs. For example, there are three 
// interior rungs in the ladder below between 'smile' and 'evote'.

//    smile smite smote emote evote

// In this problem you'll write a method that has parameters representing 
// potential interior rungs: an array of strings (these may be nonsense or 
// English words), and the anchor rungs --- two strings. Your code must 
// determine whether there exists a minimal-length ladder between the 
// exterior rungs that uses at least one interior rung. If there is any 
// such ladder the method returns "ladder", otherwise it should return 
// "none".

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