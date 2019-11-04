package section10;

import java.util.Arrays;

/**
 * sorted array, duplicate element only retain two
 */

public class ArrayDeduplicationII {
    public int[] dedup(int[] array) {
        // Write your solution here
        if(array.length <= 2){
            return array;
        }
        int slow = 2;
        for(int fast = 2; fast < array.length; fast++){
            if(array[slow - 2] != array[fast]){
                array[slow++] = array[fast];
            }
        }
        return Arrays.copyOf(array, slow+1);
    }
    public static void main(String[] args){
        ArrayDeduplicationII solution = new ArrayDeduplicationII();
        int[] array = new int[]{1, 1, 1, 2, 3};
        int[] deduparray = solution.dedup(array);
        System.out.println(Arrays.toString(deduparray));

    }
}
