// The Olympic Games will be held, and have been held (and might be 
// being held). Given the results of the olympic disciplines, 
// generate and return the medal table.

// The results of the disciplines are given as a String[] results, 
// where each element is in the format "GGG SSS BBB". GGG, SSS and 
// BBB are the 3-letter country codes (three capital letters from 
// 'A' to 'Z') of the countries winning the gold, silver and bronze 
// medal, respectively.

// The medal table is a String[] with an element for each country 
// appearing in results. Each element has to be in the format 
// "CCO G S B" (quotes for clarity), where G, S and B are the 
// number of gold, silver and bronze medals won by country CCO, 
// e.g. "AUT 1 4 1". The numbers should not have any extra leading 
// zeros.

// Sort the elements by the number of gold medals won in decreasing 
// order. If several countries are tied, sort the tied countries by 
// the number of silver medals won in decreasing order. If some 
// countries are still tied, sort the tied countries by the number 
// of bronze medals won in decreasing order. If a tie still remains, 
// sort the tied countries by their 3-letter code in ascending 
// alphabetical order.


import java.util.*;

public class MedalTable {
  public String[] generate(String[] results) {
    // you fill in this code
    String[] country = new String[3];
    HashMap<String, Integer[]> result = new HashMap<>();
    Integer[] mid;

    for (String s : results) {
      country = s.split(" ");
      for (int i=0;i<3;i++) {
          mid = result.getOrDefault(country[i], new Integer[] {0,0,0});
          mid[i] += 1;
          result.put(country[i], mid);
      }
    }

    List<Map.Entry<String, Integer[]>> infoIds = new ArrayList<Map.Entry<String, Integer[]>>(result.entrySet());

    Collections.sort(infoIds, new Comparator<Map.Entry<String, Integer[]>>() {   
      public int compare(Map.Entry<String, Integer[]> o1, Map.Entry<String, Integer[]> o2) {  
          if (o2.getValue()[0] - o1.getValue()[0] != 0) {
              return (o2.getValue()[0] - o1.getValue()[0]);
          }
          else {
            if (o2.getValue()[1] - o1.getValue()[1] != 0) {
              return (o2.getValue()[1] - o1.getValue()[1]);
            } 
            else {
              if (o2.getValue()[2] - o1.getValue()[2] != 0) {
                return (o2.getValue()[2] - o1.getValue()[2]);
              }
              else {
                return o1.getKey().compareTo(o2.getKey());
              }
            }
          }
      }
  }); 
    String[] res = new String[infoIds.size()];
    for (int i = 0; i < infoIds.size(); i++) {   
      res[i] = infoIds.get(i).getKey();
      for (Integer s: infoIds.get(i).getValue()) {
        res[i] += " " + s;
      }
    }
    
    return res;

  }
}