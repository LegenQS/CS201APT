// You are writing software to help someone understand their very 
// complicated family. Your task is to determine all aunts and 
// uncles of a given person. An aunt or uncle of a person is 
// defined as a sibling of that person's parent. Two people are 
// siblings if they have one or more parents in common.

// Create a class AuntUncle that contains a method list which 
// receives a String[], with each element containing a record 
// of a person's birth - in the form of "PARENT1 PARENT2 CHILD" 
// (quotes for clarity only), and a single String with the 
// target person's name, and returns a String[] of all aunts 
// and uncles for that target person, sorted alphabetically.

import java.util.*;

public class AuntUncle {
    public String[] list(String[] parents, String target) {
        // fill in code here
        String dad="";
        String mom="";

        if (parents.length == 1) {
            return new String[0];
        }

        for (String s: parents) {
            String[] mid = s.split(" ");
            if (target.equals(mid[2])) {
                dad = mid[0];
                mom = mid[1];
                break;
            }
        }

        ArrayList<String> res = new ArrayList<>();

        helper(getGrand(dad, mom, parents), res, parents, dad, mom, target);
        String[] result = new String[res.size()];
        res.toArray(result);
        Arrays.sort(result);

        return result; 
    }

    public ArrayList<String> getGrand(String dad, String mom, String[] parents) {
        ArrayList<String> val = new ArrayList<>();

        for (String s: parents) {
            String[] mid = s.split(" ");
            
            if (dad.equals(mid[2]) || mom.equals(mid[2])) {
                val.add(mid[0]);
                val.add(mid[1]);
            }
        }
        return val;
    }

    public void helper(ArrayList<String> grand, ArrayList<String> res, 
                String[] parents, String dad, String mom, String tar) {

        for (String s: parents) {
            String[] mid = s.split(" ");
            if (dad.equals(mid[2]) || mom.equals(mid[2]) || tar.equals(mid[2])) {
                continue;
            }

            if (grand.indexOf(mid[0]) != -1 || grand.indexOf(mid[1]) != -1) {
                res.add(mid[2]);
            }
        }
    }
}