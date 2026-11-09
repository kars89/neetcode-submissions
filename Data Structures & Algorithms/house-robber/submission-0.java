class Solution {
    int[] dp;
    public int rob(int[] nums) {    
        dp = new int[nums.length]; 
        Arrays.fill(dp, -1);
        return rob(nums, nums.length-1);
    }

    int rob(int[] nums, int i) {
        if(i<0) {
            return 0;
        }
        if(dp[i] != -1) {
            return dp[i];
        }
        dp[i] = Math.max(nums[i] + rob(nums, i-2), rob(nums, i-1));
        return dp[i];
    }
    
}
