package section10;

import java.util.Arrays;

/**
 * sorted array, duplicate element not retain any
 */
public class ArrayDeduplicationIII {
    public int[] dedup(int[] array){
        //Assumption: array is not null
        if(array == null || array.length <= 1){
            return array;
        }

        int end = 0;
        boolean flag = false;
        for(int i = 1; i < array.length; i++){
            if(array[i] == array[end]){
                //if there is duplicate, set flag and do nothign
                flag = true;
            } else if(flag == true){
                //if array[i] != array[end] and flag is set
                // array[end] should not be be included in the valid subarray
                //and we can just replace it with array[i]
                //since next we are going to check if there is
                //any duplicate of array[i]
                array[end] = array[i];
                flag = false;
            } else {
                //if array[i] != array[end]
                //and flag is not set
                //it means there is no duplicate of array[end] and it should be
                //included int he valid subarray
                array[++end] = array[i];
            }
        }
        return Arrays.copyOf(array, flag ? end : end + 1);

    }
}
