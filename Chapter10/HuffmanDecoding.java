// When text is encoded using Huffman codes, each symbol is replaced by a 
// string of 0s and 1s called a bit string representation. The replacement 
// is done in such a way that the bit string representation of a symbol is 
// never the prefix of the bit string representation of any other symbol. 
// This property allows us to unambiguously decode the encoded text.

// You will be given a String archive and a String[] dictionary. The i-th 
// element of dictionary will be the bit string representation of the i-th 
// uppercase letter. Decode archive using dictionary and return the result 
// as a single String.

import java.util.HashMap;

public class HuffmanDecoding {
      public String decode(String archive, String[] dictionary) {
            HashMap<String, String> dict = new HashMap<>();

            for (int k = 0; k < dictionary.length; k++) {
                  dict.put(dictionary[k], String.valueOf((char) (65 + k)));
            }

            String result = "";
            int i = 0;

            for (int j=i+1;j<=archive.length();j++) {
                  if (dict.containsKey(archive.substring(i, j))) {
                        result += dict.get(archive.substring(i, j));
                        i = j;
                  }
            }

            return result;

      }
}