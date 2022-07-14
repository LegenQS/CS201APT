// If you want to write a message anonymously, one way to do it is 
// to cut out letters from headlines in a newspaper and paste them 
// onto a blank piece of paper to form the message you want to 
// write. Given several headlines that you have cut out, determine 
// how many messages from a list you can write using the letters 
// from the headlines. You should only consider each message by 
// itself and not in conjunction with the others, see example 2.

// Write the method howMany which takes as parameters a String[] 
// headlines containing the headlines which you have cut out as 
// well as a String[] messages with the messages you may want to 
// write, and returns an int which is the total number of messages 
// you can write.

import java.util.*;

public class Anonymous {

    public int howMany(String[] headlines, String[] messages) {
        HashMap<String, Integer> alphbet = new HashMap<>();
        HashMap<String, Integer> idx = new HashMap<>();
        String val = "";
        int num = 0;

        for (String s: headlines) {
            for (int i=0;i<s.length();i++) {
                val = s.substring(i, i+1).toLowerCase();
                if (val == " ") {
                    continue;
                }
                if (alphbet.containsKey(val)) {
                    alphbet.replace(val, alphbet.get(val) + 1);
                }
                else {
                    alphbet.put(val, 1);
                }
            }
        }

        for (String s: messages) {
            idx.putAll(alphbet);
            for (int i=0;i<s.length();i++) {
                val = s.substring(i,i+1).toLowerCase();
                if (val.equals(" ")) {
                    continue;
                }

                if (idx.containsKey(val) && idx.get(val) > 0) {
                    idx.replace(val, idx.get(val) - 1);
                }
                else{
                    num -= 1;
                    break;
                }
            }
            num += 1;
            idx = new HashMap<>();
        }

        return num >=0 ? num : 0;
    }

    // more complicated with O(n²logn)

    // public int howMany(String[] headlines, String[] messages) {
    //     // fill in code here
    //     int num = 0;
    //     String combine = "";
    //     char[] result, idx;
    //     int pos = 0;
    //     int start = 0;

    //     for (String s: headlines) {
    //         combine += s.toLowerCase();
    //     }

    //     result = combine.toCharArray();
    //     Arrays.sort(result);
       
    //     for (String s: messages) {
    //         idx = s.toLowerCase().toCharArray();
    //         Arrays.sort(idx);
    //         if (s.length() == 0) {
    //             num += 1;
    //             continue;
    //         }
            
    //         while (start < idx.length && pos < result.length){
    //             if (idx[start] == ' '){
    //                 start += 1;
    //                 continue;
    //             }
    //             if (idx[start] == result[pos]) {
    //                 pos += 1;
    //                 start += 1;
    //             }
    //             else {
    //                 pos += 1;
    //             }
    //         }

    //         if (start == idx.length) {
    //             num += 1;
    //         }
    //         pos = 0;
    //         start = 0;
    //     }
    //     return num;
    // }
}