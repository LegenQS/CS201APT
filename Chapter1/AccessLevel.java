// In many computer systems and networks, different users are granted 
// different levels of access to different resources. In this case, 
// you are given a int[] rights, indicating the privilege level of 
// each user to use some system resource. You are also given a int 
// minPermission, which is the minimum permission a user must have to 
// use this resource.

// You are to return a String indicating which users can and cannot 
// access this resource. Each character in the return value corresponds 
// to the element of users with the same index. 'A' indicates the user 
// is allowed access, while 'D' indicates the user is denied access.

public class AccessLevel {
    public String canAccess(int[] rights, int minPermission) {
        // fill in code here
        if (rights.length == 0) {
            return "";
        }
        
        String result = "";
        for (int num: rights) {
            if (num >= minPermission) {
                result += "A";
            }
            else {
                result += "D";
            }
        }
        return result;
    }
 }