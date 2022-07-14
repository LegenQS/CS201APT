// Write method anywhere that finds each word that appears in 
// any element of parameter String[] list and returns a String 
// containing these words in alphabetical order, each separated 
// by a space.

// Each word in the string returned should be unique/different.

// Each element of list is a string of words, each separated by 
// a space. Each of these words, that appear in any element of 
// list, are represented in the string returned.

import java.util.*;

public class Closet {
    public String anywhere(String[] list) {
        // replace this with your code

        String result = helper(list, 0);
        return result;
    }

    public String helper(String[] lst, int count){
        if (lst.length == 1) {
            return lst[0];
        }
        String left = "";
        String right = "";

        if (lst.length > 2) {
            left = helper(Arrays.copyOfRange(lst, 0, lst.length / 2), count+1);
            right = helper(Arrays.copyOfRange(lst, lst.length / 2, lst.length), count+1);
        }
        else {
            left = lst[0];
            right = lst[1];
        }

        if (left.equals("") || right.equals("")) {
            return "";
        }
        HashSet<String> test = new HashSet<>();

        for (String s:left.split(" ")) {
            if (!test.contains(s)) {
                test.add(s);
            }
        }

        for (String s:right.split(" ")) {
            if (!test.contains(s)) {
                test.add(s);
            }
        }

        if (test.size() == 0) {
            return "";
        }

        String[] res = new String[test.size()];
        test.toArray(res);

        if (count == 0) {
            Arrays.sort(res);
            
        }
        return String.join(" ", res);

    }
}