// Challenge

// An entry in a Thesaurus is a list of words that are all synonyms. 
// Each entry contains no duplicates within it. It is possible that 
// two entries might have some common words, but the editors (who 
// are somewhat cheap) have decided that if any two entries have 2 
// or more words in common then they should be combined into a 
// single entry.

// This editing process may produce new entries which can be combined. 
// The final Thesaurus must contain no pair of entries that have 2 
// or more words in common. Of course, each entry must contain no 
// duplicates.

// Create a class Thesaurus that contains a method edit that is given 
// a String[] entry, the entries in the original Thesaurus. The method 
// returns the edited Thesaurus as a String[]. Each element of entry 
// has no leading or trailing spaces and has its words separated by a 
// single space. Each element of the return should also have no leading 
// or trailing spaces and have its words separated by a single space. 
// In addition, the words within each element of the return must be in 
// alphabetical order, and the elements in the return must appear in 
// alphabetical order.

import java.util.*;

public class Thesaurus {
    public String[] edit(String[] entry) {
        HashMap<String, List<Integer>> count = new HashMap<>();
        HashMap<List<Integer>, List<String>> reverse = new HashMap<>();

        for (int i=0;i<entry.length;i++) {
            for (String s : entry[i].split(" ")) {
                if (!count.containsKey(s)) {
                    count.put(s, new ArrayList<>());
                }
                count.get(s).add(i);
            }
        }

        for (String s: count.keySet()) {
            if (!reverse.containsKey(count.get(s))) {
                reverse.put(count.get(s), new ArrayList<>());
            }
            reverse.get(count.get(s)).add(s);
        }
        int pos = entry.length;
        boolean sign = true;
        List<String> val = new ArrayList<>();
        List<Integer> idx = new ArrayList<>();

        while (sign) {
            sign = false;
            // get length >= 2 with no less than 2 words
            for (List<Integer> list : reverse.keySet()) {
                // Iterator<Integer> iterator = list.iterator();
                if (list.size() >= 2 && reverse.get(list).size() >= 2) {
                    sign = true;
                    val = new ArrayList<>();
                    idx = new ArrayList<>();
                    idx.add(pos);
                    val.addAll(reverse.get(list));
                    reverse.put(idx, val);
                    idx = list;
                    reverse.remove(list);
                    break;
                }
            }

            // change index which included in the new entry
            HashMap<List<Integer>, List<Integer>> refer = new HashMap<>();
            List<Integer> mid1 = new ArrayList<>();
            List<String> mid2 = new ArrayList<>();
            for (List<Integer> list1 : reverse.keySet()) {
                for (int i : idx) {
                    if (list1.contains(i)) {
                        mid1 = new ArrayList<>();
                        mid1.add(pos);
                        
                        if (list1.size() == 1) {
                            refer.put(list1, mid1);
                        }
                        else {
                            mid1.addAll(list1);
                            mid1.remove(mid1.indexOf(i));
                            refer.put(list1, mid1);
                        }

                    }
                    break;
                }
            }

            // add to index set
            for (List<Integer> list1 : refer.keySet()) {
                mid2 = reverse.get(list1);
                reverse.remove(list1);
                reverse.put(refer.get(list1), mid2);
            }
            pos ++;
            // show(reverse);
            if (!sign) {
                break;
            }
        }     
        
        String[] result = new String[pos-1];
        HashMap<Integer, List<String>> new_count = new HashMap<>();
        for (List<Integer> list1 : reverse.keySet()) {
            for (int id : list1) {
                if (!new_count.containsKey(id)) {
                    new_count.put(id, reverse.get(list1));
                }
                else {
                    List<String> mid3 = new ArrayList<>();
                    mid3 = new_count.get(id);
                    for (String s: reverse.get(list1)) {
                        if (mid3.indexOf(s) == -1) {
                            mid3.add(s);
                        }
                    }
                }
            }
        }

        for (int key: new_count.keySet()) {
            String[] sort = new String[new_count.get(key).size()];
            Arrays.sort(new_count.get(key).toArray(sort));
            result[key] = String.join(" ", sort);
        }
        Arrays.sort(result);
        
        return result;
    }

    // public void show(HashMap<List<Integer>, List<String>> reverse) {
    //     for (List<Integer> a : reverse.keySet()) {
    //         for (int i: a) {
    //             System.out.print(i + " ");
    //         }
    //         System.out.print(":" + " ");
    //         for (String s: reverse.get(a)) {
    //             System.out.print(s + " ");
    //         }
    //         System.out.println("");
    //     }
    // }
}