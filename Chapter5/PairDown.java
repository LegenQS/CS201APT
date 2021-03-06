// Write a method fold that has an int[] parameter and that 
// returns an int[] array formed by summing each adjacent 
// pairs of integer values in the parameter.

// For example, if list is {7, 2, 8, 9, 4, 13, 7, 1, 9, 10}, 
// then the returned array is {9, 17, 17, 8, 19}.

// Note that 7 + 2 = 9, 8+9 = 17, 4+13 = 17, 7+1=8, and 
// 9+10=19. If list stores an odd number of elements, the 
// final element is summed with zero since there is no 
// adjacent value. For example, for {1, 2, 3, 4, 5} the 
// return array is {3, 7, 5}.


public class PairDown {
    public int[] fold(int[] list) {
        // change this code
        int num = (int) Math.floor((list.length+1)/2);
        int[] res = new int[num];

        for(int i=0;i<list.length;i+=2) {
            if (i==list.length-1) {
                res[(int) (i/2)]=  list[i];
            }
            else {
                res[(int) (i/2)] = list[i] + list[i+1];
            }

        }
        return res;
    }
}