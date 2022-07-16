// The Erdos number is a way of describing the "collaborative distance" between 
// a scientist and Paul Erdos by authorship of scientific publications.

// Paul Erdos is the only person who has an Erdos number equal to zero. To be 
// assigned a finite Erdos number, a scientist must publish a paper in 
// co-authorship with a scientist with a finite Erdos number. The Erdos number 
// of a scientist is the lowest Erdos number of his coauthors + 1. The order 
// of publications and numbers assignment doesn't matter, i.e., after each 
// publication the list of assigned numbers is updated accordingly.

// You will be given a String[] pubs, each element of which describes the list 
// of authors of a single publication and is formatted as "AUTHOR_1 AUTHOR_2 ... 
// AUTHOR_N" (quotes for clarity only). Paul Erdos will be given as "ERDOS".

// Return the list of Erdos numbers which will be assigned to the authors of the 
// listed publications. Each element of your return should be formatted as 
// "AUTHOR NUMBER" if AUTHOR can be assigned a finite Erdos number, and just 
// "AUTHOR" otherwise. The authors in your return must be ordered lexicographically.

import java.util.ArrayList;

public class ErdosNumber {
    public String[] calculateNumbers(String[] pubs) {
      // you write code here
        ArrayList<String> assigned = new ArrayList<>();
        assigned.add("ERDOS");
        ArrayList<String> assign_seq = new ArrayList<>();
        assign_seq.add("0");
        int assign_index = 1;
        int walk_length = 0;

        while (walk_length < pubs.length) {
            for (String publishers : pubs) {
                String[] publisher = publishers.split(" ");
                if (assigned.contains(publisher[0])) {
                    assign_index = Integer.valueOf(assign_seq.get((assigned.indexOf(publisher[0])))).intValue();
                    for (int i = 1; i < publisher.length; i++) {
                        if (!assigned.contains(publisher[i])) {
                            assigned.add(publisher[i]);
                            assign_seq.add(String.valueOf(assign_index));
                            assign_index += 1;
                        }
                        else {
                            assign_index = Integer.valueOf(assign_seq.get((assigned.indexOf(publisher[i])))).intValue();
                        }
                    }
                    walk_length += 1;
                }
            }
        }
        String[] result = new String[assigned.size()];
        for (int i = 0; i < assigned.size(); i++) {
            result[i] = assigned.get(i) + " " + assign_seq.get(i);
        }
        return result;
    }
  }