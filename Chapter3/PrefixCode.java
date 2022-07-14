// Challenge O(n²)
// Achieve O(nlogC) by prefix tree structure

// A prefix code is a set of words in which no word is a prefix of 
// another word in the set. A word v is said to be a prefix of a 
// word w if w starts with v.

// An important property of prefix codes is that they are uniquely 
// decodable. Prefix codes are commonly used - telephone numbers 
// are an everyday example (as you probably don't want a stranger 
// to pick up the phone call you make just because his number is 
// a prefix of the number you intend to dial). Prefix codes are 
// also very popular in computer science, the Huffman code used 
// for data compression being a famous example.

// Given a String[] words, return the String "Yes" if that set of 
// words is a prefix code or return the String "No, i" if it is 
// not, where i is replaced by the lowest 0-based index of a 
// String in words that is a prefix of another String in words. 
// (That index should have no extra leading zeros.)


public class PrefixCode { 
    public String isOne(String[] words) {
        int idx = 10000;
        for (int i=0; i<words.length-1;i++) {
            for (int j=i+1;j<words.length;j++) {
                if (words[i].startsWith(words[j])) {
                    idx = Math.min(idx, j);
                } 
                if (words[j].startsWith(words[i])) {
                    idx = Math.min(idx, i);
                }
            }
        }
        if (idx != 10000) {
            return "No, " + idx;
        }
        return "Yes";
    }
}