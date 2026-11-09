class Solution {
    public int maxSubArray(int[] nums) {
        int maxSub = nums[0];
        int curSub = 0;

        for(int n : nums) {
            if(curSub < 0) {
                curSub = 0;
            }
            curSub = curSub + n;
            maxSub = Math.max(maxSub, curSub);
        }
        return maxSub;
    }
}
