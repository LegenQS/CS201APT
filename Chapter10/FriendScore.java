// You want to determine the most popular person in a social network. 
// To do this, you will count the number of "2-friends" that each 
// person has. Person A is called a 2-friend of another person B if 
// they are friends with each other or if there exists some person C 
// who is a friend of both A and B. The most popular person is the 
// person with the highest number of 2-friends. (There might be more 
// than one if multiple people all have the maximal number of 
// 2-friends.)

// You are given a String[] friends, where the j-th character of the 
// i-th element is 'Y' if person i and person j are friends, and 'N' 
// otherwise. Return the number of 2-friends of the most popular 
// person in this social network.

import java.util.*;

public class FriendScore {

    // complicated method 

    // public int highestScore(String[] friends) {
    // // you fill in code here
    // int res = 0;
    // String[] count = new String[friends.length];

    // for (int i=0;i<friends.length; i++) {
    // for (int j=i+1;j<friends[i].length();j++) {
    // if (friends[i].substring(j,j+1).equals("Y")) {
    // if (count[i] == null) {
    // count[i] = String.valueOf(j) + " ";
    // }
    // else {
    // count[i] += String.valueOf(j) + " ";
    // }

    // if (count[j] == null) {
    // count[j] = String.valueOf(i) + " ";
    // }
    // else {
    // count[j] += String.valueOf(i) + " ";
    // }
    // }
    // }
    // }

    // for (int i=0;i<friends.length;i++) {
    // HashSet<String> refer = new HashSet<>();
    // if (count[i] == null) {
    // continue;
    // }
    // for (String s : count[i].split(" ")) {
    // refer.add(s);
    // if (count[Integer.parseInt(s)] == null) {
    // continue;
    // }
    // for (String ss : count[Integer.parseInt(s)].split(" ")){
    // refer.add(ss);
    // };
    // }
    // refer.remove(String.valueOf(i));
    // res = Math.max(res, refer.size());
    // }

    // return res;
    // }
    // }

    // recursively

    public int highestScore(String[] friends) {
        int count = 0;

        for (int i=0; i < friends.length; i++) {
            HashSet<Integer> val = new HashSet<>();
            for (int j=0;j<friends[i].length();j++) {
                if (friends[i].substring(j,j+1).equals("Y")) {
                    val.add(j);
                    Loop(val, j, friends);
                }
            }
            if (val.contains(i)) {
                val.remove(i);
            }
            count = Math.max(count, val.size());
        }
        return count;
    }

    public void Loop(HashSet<Integer> val, int idx, String[] friends) {
        for (int i = 0; i < friends[idx].length(); i++) {
            if (friends[idx].substring(i, i + 1).equals("Y"))
                val.add(i);
        }
    }

}