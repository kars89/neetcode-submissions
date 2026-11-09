class Solution {
    int[] dp;
    public int rob(int[] nums) {
        dp = new int[nums.length];
         Arrays.fill(dp, -1);
        return rob(nums, 0);
    }

    int rob(int[] nums, int i) {

        if(i >= nums.length) {
            return 0;
        }
        if(dp[i] != -1) {
            return dp[i];
        }

        int inc = nums[i] + rob(nums, i+2);
        int exc = rob(nums, i+1);

        dp[i] =  Math.max(inc, exc);

        return dp[i];
    }
}
