package dp;

public class CombinationSumIV {
    public int combinationSum4(int[] nums, int target){
        if(nums == null || nums.length == 0){
            return 0;
        }

        int[] dp = new int[target + 1];

        dp[0] = 1;
        for(int i = 1; i <= target; i++){
            for(int j = 0; j < nums.length; j++){
                if(i - nums[j] >= 0){
                    dp[i] += dp[i- nums[j]];
                }
            }
        }
        return dp[target];
    }

    public static void main(String[] args){
        CombinationSumIV solution = new CombinationSumIV();
        int[] nums = new int[]{1, 2, 3};
        int result = solution.combinationSum4(nums, 4);
        System.out.println("result: " + result);
    }
}
