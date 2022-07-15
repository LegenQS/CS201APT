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