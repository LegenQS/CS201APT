// The Simple Word Game is a game where a player tries to remember 
// as many words as possible from a given dictionary. The score 
// for each distinct word that the player remembers correctly is 
// the square of the word's length.

// You are given a String[] player, each element of which is a word 
// remembered by the player. There may be duplicate words, but if 
// the same word appears multiple times, it should only be counted 
// once. You are given the dictionary in the String[] dictionary, 
// each element of which is a single distinct word. Return the 
// player's total score.

import java.util.*;

public class SimpleWordGame {
    public int points(String[] player, 
                      String[] dictionary) {
        // you write code here
        HashSet<String> result = new HashSet<>(Arrays.asList(dictionary));
        int val = 0;
        // Hashset<String> result = new HashSet<>(Arrays.asList(dictionary));
        for (String word: player) {
            if (result.contains(word)) {
                val += Math.pow(word.length(), 2);
                result.remove(word);
            }
        }
        return val;
    }
}