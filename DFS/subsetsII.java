package DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class subsetsII {

    public List<List<Integer>> subsetsWithDup(int[] nums){
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        dfs(nums, 0, new ArrayList<>(), result);
        return result;
    }

    public void dfs(int[] nums, int index, List<Integer> path, List<List<Integer>> result){
        result.add(path);
        for(int i = index; i< nums.length; i++){
            if( i > index && nums[i] == nums[i-1]) continue;
            List<Integer> nPath = new ArrayList<>(path);
            nPath.add(nums[i]);
            dfs(nums, i+ 1, nPath, result);
        }
    }

    public static void main(String[] args){
        subsetsII solution = new subsetsII();
        int[] nums = new int[]{1, 2, 2, 3};
        List<List<Integer>> result = solution.subsetsWithDup(nums);
        System.out.println(result);
    }
}
