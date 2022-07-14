// The frequency with which data occurs is sometimes an important 
// statistic. In this problem you are given an array of strings 
// and must determine how frequently the strings occur. Return an 
// array of strings that is sorted (ordered) by frequency. The 
// first element of the returned array is the most frequently 
// occurring string, the last element is the least frequently 
// occurring. Ties are broken by listing strings in 
// lexicographic/alphabetical order. The returned array contains 
// one occurrence of each unique string from the array parameter.

import java.util.*;

public class SortByFreqs {
    public String[] sort(String[] data) {
        TreeMap<String, Integer> tmap = new TreeMap<>();
        for (String a: data) {
            tmap.putIfAbsent(a, 0);
            tmap.put(a, tmap.get(a)+1);
        }
        ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>(tmap.entrySet());
        Collections.sort(list, Collections.reverseOrder(Comparator.comparing(Map.Entry::getValue)));

        String[] ans = new String[list.size()];
        for(int i=0;i<list.size();i++) {
            ans[i] = list.get(i).getKey();
        }
        
        return ans;
    }
}