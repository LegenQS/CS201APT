// Challenge

// Syllable sorting is a method of sorting words based on their syllabic 
// decompositions. The first step is to decompose each word into syllables. 
// A syllable is defined as a maximal non-empty substring of consonants 
// followed by a maximal non-empty substring of vowels. The only vowels 
// are 'a', 'e', 'i', 'o' and 'u'. All other letters are considered 
// consonants. All words will start with a consonant and end with a vowel.

// To compare two words syllabically, first decompose them into sequences 
// of syllables. For example, the words "zcdbadaerfe" and "foubsyudba" 
// decompose as follows:

// "zcdbadaerfe" = {"zcdba", "dae", "rfe"}
// "foubsyudba" = {"fou", "bsyu", "dba"}
// Then, sort each sequence of syllables alphabetically. In the above 
// example, the sequences become:

// {"dae", "rfe", "zcdba"}
// {"bsyu", "dba", "fou"}

// Then, compare these sorted sequences lexicographically. A sequence S1 
// comes before a sequence S2 lexicographically if S1 has an alphabetically 
// earlier element at the first index at which they differ. In the above 
// example, the second sequence comes earlier lexicographically because 
// "bsyu" comes before "dae" alphabetically.

// If two sorted sequences are equal, then compare their corresponding 
// unsorted sequences instead. For example, the words "daba" and "bada" 
// decompose into the same sorted sequence {"ba", "da"}. Compare the 
// unsorted sequences {"da", "ba"} and {"ba", "da"} to determine that 
// "bada" comes before "daba".


import java.util.*;
import java.util.Map.Entry;

public class SyllableSorting {
    private HashSet<String> vowels = new HashSet<String>() {};

    public String[] sortWords(String[] words) {
        String[] val = new String[words.length];
        HashMap<String, String[]> refer = new HashMap<>();
        HashMap<String, Integer> count = new HashMap<>();
        int pos = 0;
        // initialization
        vowels.add("a");
        vowels.add("e");
        vowels.add("i");
        vowels.add("o");
        vowels.add("u");

        for (String s: words) {
            count.put(s, count.getOrDefault(s, 0) + 1);
            refer.put(s, decompose(s, true));
        }
        List<Map.Entry<String, String[]>> result = new ArrayList<>(refer.entrySet());
        Collections.sort(result, new Comparator<Map.Entry<String, String[]>>() {

            @Override
            public int compare(Entry<String, String[]> o1, Entry<String, String[]> o2) {
                String[] s1 = o1.getValue();
                String[] s2 = o2.getValue();
                int length = Math.min(s1.length, s2.length);

                for (int i=0;i<length;i++) {
                    if (s1[i].equals(s2[i])) {
                        continue;
                    }
                    else {
                        return s1[i].compareTo(s2[i]);
                    }
                }
                if (s1.length != s2.length) {
                    return s1.length > s2.length ? 1 : -1;
                }

                s1 = decompose(o1.getKey(), false);
                s2 = decompose(o2.getKey(), false);

                for (int i=0;i<length;i++) {
                    if (s1[i].equals(s2[i])) {
                        continue;
                    }
                    else {
                        return s1[i].compareTo(s2[i]);
                    }
                }
                return 0;
            }  
        });

        for (Map.Entry<String, String[]> s: result) {
            for (int i=0;i<count.get(s.getKey());i++) {
                val[pos++] = s.getKey();
            }
        }
        return val;
    }


    public String[] decompose(String s, boolean sort) {
        ArrayList<String> res = new ArrayList<>();
        String val = "";
        boolean vowel_sign = false;

        for (int i = 0; i < s.length(); i++) {
            if (vowels.contains(s.substring(i, i + 1))) {
                vowel_sign = true;
            } 
            else {
                if (vowel_sign) {
                    vowel_sign = false;
                    res.add(val);
                    val = "";
                }
            }

            val += s.substring(i, i + 1);
        }

        if (val.length() != 0) {
            res.add(val);
        }
        
        String[] result = new String[res.size()];
        res.toArray(result);
        if (sort) {
            Arrays.sort(result);
        }
    
        return result;
    }
}