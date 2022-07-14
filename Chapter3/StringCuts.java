// Filtering data often requires determining which data elements 
// satisfy a specific criterion. Write method filter which has 
// two parameters: a String[] of data to be filtered and an int 
// parameter indicating the minimum acceptable length for the 
// string data.

// Return a String[] array of the unique strings in list whose 
// lengths are greater than or equal to minLength.

// The string values in the returned array should be in the same 
// order they appear in list. The strings in the returned array 
// should be unique, so conceptually only the first of any 
// duplicate elements in list that pass the length requirement 
// is in the returned array. See the examples for details.

public class StringCuts {
    public String[] filter(String[] list, int minLength) {
        // replace this with your code
        int j = 0;
        boolean sign;
        for(int i=0;i<list.length;i++) {
            if (list[i].length() >= minLength) {
                sign = false;
                if (j != 0) {
                    for (int k=0;k<j;k++) {
                        if (list[i].equals(list[k])) {
                            sign = true;
                            break;
                        }
                        
                    }
                }
                if (!sign) {
                    list[j] = list[i];
                    j += 1;
                }
            }
        }

        String[] result = new String[j];
        for (int i=0;i<j;i++) {
            result[i] = list[i];
        }
        return result;
    }
}