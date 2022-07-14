// In days of yore, aka BG (Before Google), search engines 
// ranked webpages in part by the number of occurrences of 
// a word on the page. You should write method most to 
// determine and return the word that occurs most often in 
// an array of sentences. This most frequently occurring 
// word will be unique --- that is you don't need to worry 
// about two words both occuring more often than any other 
// word. The word returned should be all lower-case 
// regardless of the case of leters in sentences.

// Each string in sentences represents several words, each 
// word is delimited by spaces from other words. Words 
// should be considered the same without respect to case, 
// so BIG is the same word as big, for example.

import java.util.HashMap;

public class BigWord {
    public String most(String[] sentences) {
        // you write code heref
        HashMap<String, Integer> result = new HashMap<>();
        String val = "";
        int max = 0;
        String idx;
        for (String sentence: sentences) {
            for (String s: sentence.split(" ")) {
                idx = s.toLowerCase();
                if (result.containsKey(idx)) {
                    result.replace(idx, result.get(idx) + 1);
                    if (max < result.get(idx)) {
                        val = idx;
                        max = result.get(idx);
                    }
                }
                else {
                    result.put(idx, 1);
                }
            }
        }

        return val;
    }
}