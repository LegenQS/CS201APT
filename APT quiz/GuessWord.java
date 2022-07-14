import java.util.HashMap;

public class GuessWord {
    public int getPoints(String word, String target) { 
        // TODO: fill in code here
        HashMap<Character, Integer> set1 = new HashMap<>();
        HashMap<Character, Integer> set2 = new HashMap<>();

        int point = 0;
        for (int i=0; i < word.length(); i++) {
            if (word.charAt(i) == target.charAt(i)) {
                point += 1;
                if (!set1.containsKey(word.charAt(i))) {
                    set1.put(word.charAt(i), 1);
                }
                else {
                    set1.replace(word.charAt(i), set1.get(word.charAt(i))+1);
                }
                if (!set2.containsKey(word.charAt(i))) {
                    set2.put(word.charAt(i), 1);
                }
                else {
                    set2.replace(word.charAt(i), set2.get(word.charAt(i))+1);
                }
            }
            else {
                if (!set1.containsKey(word.charAt(i))) {
                    set1.put(word.charAt(i), 1);
                }
                else {
                    set1.replace(word.charAt(i), set1.get(word.charAt(i))+1);
                }
                if (!set2.containsKey(target.charAt(i))) {
                    set2.put(target.charAt(i), 1);
                }
                else {
                    set2.replace(target.charAt(i), set2.get(target.charAt(i))+1);
                }
            }
        }

        for (Character s: set1.keySet()) {
            if (set2.containsKey(s)) {
                point += Math.min(set1.get(s), set2.get(s));
            }
        }

        return point;
    }
}