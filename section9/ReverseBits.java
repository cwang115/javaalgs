package section9;

public class ReverseBits {

    public int reverseBits(int n){
        //corner case all 0 or all 1

        int result = 0;

        for(int i = 0; i < 32; i++){
            int temp = (n >> i) & 1;
            result |= temp << (31- i);
        }

        return result;
    }

    public int reverseBitsII(int n ){

        //in-place

        for(int i =0; i <16; i++){
            //swap when different
            //swap is actually flipping
            if( ((n >> i) & 1) ==(n >> ((31 - i) )& 1) ){
                continue;
            } else {
                //xor 1 can flip the bit
                n ^= 1 << i;
                n ^= 1 << (31 - i);

            }
        }

        return n;
    }

    public static void main(String[] args){
        ReverseBits solution = new ReverseBits();
        System.out.println(5);
        System.out.println(Integer.toBinaryString(5));
        int result = solution.reverseBitsII(5);
        System.out.println(result);
        System.out.println(Integer.toBinaryString(result));
    }

}
