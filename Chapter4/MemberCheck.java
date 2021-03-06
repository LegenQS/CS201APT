// A health club chain allows its members to visit any of 
// its many health club locations an unlimited number of 
// times per day. The only constraining rule is, a customer 
// can only visit one health club location per day, even 
// though he or she may return to that location an unlimited 
// number of times for the rest of that day.

// Although the honor system has always worked quite well, 
// the club wants to run some tests to see how many people 
// really follow the rules. You are to write a program that 
// takes the entrance log files from three different clubs 
// (all logging the same day) and return a sorted list of 
// the people who are not honest and went to more than one 
// health club location in the same day.

The log files are represented as String[]'s where each element is the member name of a customer who entered that day. For example, if a customer showed up three times to one of the club locations that day, the member's name would appear three times in the corresponding String[].

import java.util.*;

public class MemberCheck {
  public String[] whosDishonest(String[] club1, String[] club2, String[] club3) {
    List<String> list = new ArrayList<>();
    HashMap<String, Integer> myHash = new HashMap<>();
    for (String club : club1) {
      if (!myHash.containsKey(club)) {
        myHash.put(club, 1);
      }
    }

    for (String club : club2) {
      if (!myHash.containsKey(club)) {
        myHash.put(club, 0);
      } else {
        if (myHash.get(club) == 1) {
          list.add(club);
          myHash.replace(club, -1);
        }
      }
    }

    for (String club : club3) {
      if (myHash.containsKey(club)) {
        if (myHash.get(club) >= 0) {
          list.add(club);
          myHash.replace(club, -1);
        }
      }
    }
    String[] result = new String[list.size()];
    Collections.sort(list);
    list.toArray(result);
    return result;
  }
}