package suanfage2pointers;

public class SubarraySumEqualsK {
    /**
     * optimize space complexity to O(1)
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        // int[] sum = new int[nums.length + 1];
        // sum[0] = 0;

        for (int start = 0; start < nums.length; start++) {
            int sum = 0;
            for (int end = start; end < nums.length; end++) {
                sum += nums[end];
                if(sum == k){
                    count++;
                }
            }
        }
        return count;
    }
    public static void main(String[] args){
        SubarraySumEqualsK solution = new SubarraySumEqualsK();
        int[] array = new int[]{2, 4, 5,6, 1};
        int result = solution.subarraySum(array, 5);
        System.out.println(result);
    }
}
