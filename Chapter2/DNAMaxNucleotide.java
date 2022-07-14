// Write code to find which of the strands representing DNA in 
// an array String[] strand representing strands of DNA has the 
// most occurrences of the nucleotide represented by parameter 
// nuc.

// If more than one strand has the same maximal number of the 
// specified nucleotide you should return the longest strand 
// with the maximal number. All DNA strands have different 
// lengths in this problem so the maximal strand will be 
// unique when length is accounted for. Return this uniquely 
// maximal strand.

// Each String representing a DNA strand will contain only 
// cytosine, guanine, thymine, and adenine, represented by 
// the characters 'c', 'g', 't', and 'a', respectively. If 
// no strand in the array contains the specified nucleotide 
// return the empty string "".

public class DNAMaxNucleotide {
    public String max(String[] strands, String nuc) {
        if (nuc.length() == 0){
            return "";
        }

        String result = "";
        int DNA_length = 0;
        int cur_length = 0;
        int pos = 0;

        for (String DNA : strands){
            if (DNA.contains(nuc)){
                pos = DNA.indexOf(nuc);
                while (pos != -1) {
                    DNA_length += 1;
                    pos = DNA.indexOf(nuc, pos+1);
                }
                if (cur_length == 0 || (DNA_length > cur_length) || (DNA.length() > result.length() && DNA_length == cur_length)){
                    result = DNA;
                    cur_length = DNA_length;
                }
            }
            DNA_length = 0;
        }
        return result;
  }
}
