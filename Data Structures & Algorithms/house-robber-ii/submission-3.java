class Solution {
    int[] dp;
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        dp = new int[nums.length]; 
        Arrays.fill(dp, -1);
        int robLast = rob(nums, nums.length-1, true);
        Arrays.fill(dp, -1);
        int skipLast = rob(nums, nums.length-2, false);
        return Math.max(robLast, skipLast);
    }
    int rob(int[] nums, int i, boolean isLast) {
        if(isLast && i == 0) {
            return 0;
        }
        if(i<0) {
            return 0;
        }
        if(dp[i] != -1) {
            return dp[i];
        }
        dp[i] = Math.max(nums[i] + rob(nums, i-2, isLast), rob(nums, i-1, isLast));
        return dp[i];
    }
}
