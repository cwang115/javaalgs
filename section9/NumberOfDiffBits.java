package section9;

public class NumberOfDiffBits {
    public int diffBits(int a, int b){
        //exclusive or, only the bits where a and b
        //are different will be 1
        a ^= b;
        int count =0;

        while(a!=0){
            count += a & 1;
            a >>>= 1;
        }

        return count;
    }
}
