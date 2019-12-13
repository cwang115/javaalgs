package section1;

import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingSubsequnce {
    public int lengthOfLISII(int[] nums) {
        //cc
        if(nums == null || nums.length == 0){
            return 0;
        }
        //create a int[] dp to record the length of previous subsequence
        //dp[i]: the length of longest increasing subsequence up to ith index
        int[] dp = new int[nums.length];
        int maxVal = 1;
        /**
         *
         * [0]
         */
        //base case: dp[0] = 1;
        dp[0] = 1;

        for(int i =1; i< nums.length; i++){
            dp[i] = 1;
            //use j
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxVal = Math.max(dp[i], maxVal);
        }

        return maxVal;
    }

        public int lengthOfLIS(int[] nums) {
            //corner case
            if (nums == null || nums.length == 0) {
                return 0;
            }
            List<Integer> res = new ArrayList<>();
            res.add(nums[0]);
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] > res.get(res.size() - 1)) {
                    res.add(nums[i]);
                } else {
                    update(res, nums[i]);
                }
            }
            return res.size();
        }
        private void update(List<Integer> res, int target) {
            int start = 0;
            int end = res.size() - 1;
            while (start <= end) {
                int mid = start + (end - start) / 2;
                if (res.get(mid) > target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            res.set(start, target);
        }

        public static void main(String[] args){
            LongestIncreasingSubsequnce solution = new LongestIncreasingSubsequnce();
            int[] nums = {0};
            System.out.println(solution.lengthOfLISII(nums));
        }
}
