package section10;

import java.util.Arrays;

/**
 * unsorted array, repeatedly deduplication
 */
public class ArrayDeduplicationIV {
    public int[] dedup(int[] array) {
        // Write your solution here
        //cc
        if(array.length <= 1){
            return array;
        }
        //use the array before end
        int end = -1;
        for(int i = 0; i < array.length; i++){
            if(end == -1 || array[end] != array[i]){
                array[++end] = array[i];
            } else {
                while(i + 1 < array.length && array[i+1] == array[end]){
                    i++;
                }
                end--;
            }
        }

        return Arrays.copyOf(array, end+1);

    }



}
