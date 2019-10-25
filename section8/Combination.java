package section8;

import java.util.ArrayList;
import java.util.List;

public class Combination {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> cur = new ArrayList<Integer>();
        helper(candidates, 0, target, 0, cur, res);
        return res;
    }

    private void helper(int[] candidates, int start, int target, int sum, List<Integer> cur, List<List<Integer>> res){
        //termination
        if(sum > target){
            return;
        }

        if(sum == target){
            res.add(new ArrayList<>(cur));
            return;
        }

        for(int i = start; i < candidates.length; i++){
            cur.add(candidates[i]);
            helper(candidates, i, target, sum + candidates[i], cur, res);
            cur.remove(cur.size() - 1);
        }

    }
}

