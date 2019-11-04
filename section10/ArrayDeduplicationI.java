package section10;

import java.util.Arrays;

public class ArrayDeduplicationI {
    public int[] dedup(int[] array){
        //cc
        if( array.length <= 1){
            return array;
        }

        int s = 0;
        for(int f = 1; f<array.length; f++){
            if(array[s] != array[f]){
                array[++s] = array[f];

            }
        }
        return Arrays.copyOf(array, s+1);

    }

    public static void main(String[] args){
        ArrayDeduplicationI solution = new ArrayDeduplicationI();
        int[] array = new int[]{1, 1, 1, 2, 3};
        int[] deduparray = solution.dedup(array);
        System.out.println(Arrays.toString(deduparray));

    }
}
