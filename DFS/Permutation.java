package DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {

    //dfs solution with swapping
    public List<String> permutations(String set){
        List<String> result = new ArrayList<String>();
        if(set == null){
            return result;
        }

        char[] array = set.toCharArray();
        helper(array, 0, result);
        return result;
    }

    private void helper(char[] array, int index, List<String> result){
        //terminate condition
        //only when we have already chosen the characters for all the position
        //we can have a complete permutation
        if(index == array.length){
            result.add(new String(array));
            return;
        }

        //all the possible characters could be placed at index
        //are the characters in the subarray(index, array.length - 1)
        for(int i = index; i < array.length; i++){
            swap(array, index, i);
            helper(array, index + 1, result);
            swap(array, index, i);
        }
        }

        private void swap(char[] array, int left, int right){
            char tmp = array[left];
            array[left] = array[right];
            array[right] = tmp;
        }
        public static void main(String[] args){
            Permutation solution = new Permutation();
            //int[] array = new int[]{1, 2, 3, 4};
            //List<Integer> arraylist = Arrays.asList(array);


            String[] array = {"a", "b", "c", "d", "e"};

            //Method 1
            List<String> list = Arrays.asList(array);
            System.out.println(list);
        }
}
