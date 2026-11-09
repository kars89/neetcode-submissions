class Solution {
    int[] dp;
    public int rob(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        dp = new int[nums.length];
        Arrays.fill(dp, -1);
        int choseFirst = rob(nums, 0, true);

        Arrays.fill(dp, -1);
        int notChoseFirst = rob(nums, 1, false);

        return Math.max(choseFirst, notChoseFirst);
        
    }

    int rob(int[] nums, int i, boolean choseFirst) {

        if(i == nums.length-1) {
            if(choseFirst) {
                return 0;
            } else {
                return nums[i];
            }
        }

        if(i >= nums.length) {
            return 0;
        }

        if(dp[i] != -1) {
            return dp[i];
        }

        int inc = nums[i] + rob(nums, i+2, choseFirst);
        int exc = rob(nums, i+1, choseFirst);
        dp[i] = Math.max(inc, exc);

        return dp[i];
    }
}
