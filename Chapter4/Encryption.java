// John is obsessed with security. He is writing a letter to his 
// friend Brus and he wants nobody else to be able to read it. 
// He uses a simple substitution cipher to encode his message. 
// Each letter in the message is replaced with its corresponding 
// letter in a substitution alphabet. A substitution alphabet is 
// a permutation of all the letters in the original alphabet. In 
// this problem, the alphabet will consist of only lowercase 
// letters ('a'-'z').

// For example, if John's message is "hello" and his cipher maps 
// 'h' to 'd', 'e' to 'i', 'l' to 'p' and 'o' to 'y', the encoded 
// message will be "dippy". If the cipher maps 'h' to 'a', 'e' to 
// 'b', 'l' to 'c' and 'o' to 'd', then the encoded message will 
// be "abccd".

// Given the original message, determine the cipher that will 
// produce the encoded string that comes earliest alphabetically. 
// Return this encoded string. In the example above, the second 
// cipher produces the alphabetically earliest encoded string 
// ("abccd").

import java.util.HashMap;

public class Encryption {
    public String encrypt(String message){
        // you write code here
        HashMap<String, String> map = new HashMap<>();
        int start = 97;
        String res = "";
        String idx = "";

        for (int i=0;i<message.length();i++){
            idx = message.substring(i,i+1);
            if (map.containsKey(idx)) {
                res += map.get(idx);
            }
            else {
                map.put(idx, String.valueOf((char) start));
                start += 1;
                res += map.get(idx);
            }
        }

        return res;
    }
}