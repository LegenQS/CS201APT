// In some filesystems, the disk space used by a file is not 
// always equal to the file's size. This is because the disk 
// is divided into clusters of equal size, and each cluster 
// can only be used by a single file. For example, if the 
// cluster size is 512 bytes, and we have a file of size 600 
// bytes, it would have to be stored in two clusters. Those 
// two clusters cannot be shared with any other files, so the 
// file ends up using 1024 bytes of disk space.

// You are given a int[] sizes, where each element is the size 
// of a single file, and an int clusterSize, the cluster size 
// of the filesystem. Return the total disk space used by the 
// given files.

public class TrueSpace {
    public long calculateSpace(int[] sizes, int clusterSize) {
       // fill in code here
        long result = 0;
        for (int size: sizes) {
            if (size != 0){
                if (size % clusterSize == 0) {
                    result += size;
                }
                else {
                    result += (Math.floor(size / clusterSize) + 1) * clusterSize; 
                }
                
            }
        }

        return result;
    }
    
}