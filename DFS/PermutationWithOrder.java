package DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationWithOrder {
    public List<String> permutationsWithOrder(String set){
        List<String> result = new ArrayList<String>();
        if(set == null){
            return null;
        }

        char[] arraySet = set.toCharArray();
        Arrays.sort(arraySet);
        //record which index has been used in the original arraySet
        boolean[] used = new boolean[arraySet.length];
        StringBuilder cur = new StringBuilder();
        helperWithOrder(arraySet, used, cur, result);
        return result;

    }

    private void helperWithOrder(char[] array, boolean[] used, StringBuilder cur, List<String> result){
        //terminate condition
        //when the permutation contains all the characters in the original array
        if(cur.length() == array.length){
            result.add(cur.toString());
            return;
        }

        //when picking the next char, always according to the order
        for(int i = 0; i < array.length; i++){
            if(!used[i]){
                used[i] = true;
                cur.append(array[i]);
                helperWithOrder(array, used, cur, result);
                used[i] = false;
                cur.deleteCharAt(cur.length() - 1);
            }
        }
    }
}
