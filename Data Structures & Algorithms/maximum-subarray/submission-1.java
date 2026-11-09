class Solution {
    public int maxSubArray(int[] nums) {
        int left = 0;

        int maxSum = -1;
        int curSum = 0;
        for(int i=left; i < nums.length; i++) {
            curSum = curSum + nums[i];
            maxSum = Math.max(maxSum, Math.max(nums[i], curSum));
            if(curSum < 0) {
                curSum = 0;
            }
            
        }
        return maxSum;
    }
}
