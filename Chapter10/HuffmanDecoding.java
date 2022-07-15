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