// Challenge
// O(nlogC) + O(n)

// Two words are called isomorphic if the letters in one word can 
// be remapped to get the second word. Remapping a letter means 
// replacing all occurrences of it with another letter. The 
// ordering of the letters remains unchanged. No two letters may 
// map to the same letter, but a letter may map to itself.

// For example, the words "abca" and "zbxz" are isomorphic because 
// we can map 'a' to 'z', 'b' to 'b' and 'c' to 'x'.

// Given a String[] words, return how many (unordered) pairs of 
// words are isomorphic.

import java.util.HashMap;

public class IsomorphicWords {
   public int countPairs(String[] words) {
      String [] reflect = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
      
      int result = 0;
      HashMap<String, String> myHash = new HashMap<>();
      HashMap<String, Integer> mySet = new HashMap<>();
      String midIdx = "";
      int count = 0;
      for (String word : words) {
         midIdx = "";
         count = 0;
         myHash = new HashMap<>();
         for (int i=0; i<word.length(); i++) {
            if (!myHash.containsKey(word.substring(i, i+1))) {
               myHash.put(word.substring(i, i+1), reflect[count++]);
            }
            midIdx += myHash.get(word.substring(i, i+1));
         }
         if (mySet.containsKey(midIdx)) {
            mySet.replace(midIdx, mySet.get(midIdx)+1);
         }
         else {
            mySet.put(midIdx, 1);
         }
      }

      // get all pairs of combination with C(n,2)
      for (String key : mySet.keySet()) {
         if (mySet.get(key) != 1) {
            count = 1;
            for (int i=mySet.get(key)-1; i<= mySet.get(key); i++) {
               count *= i;
            }
            result += count / 2;
         }
      }
      return result;
   }
 }