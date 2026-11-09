class Solution {
    public int maxProduct(int[] nums) {
        int curMax = 1;
        int curMin = 1;

        int res = nums[0];
        for(int i=1; i< nums.length; i++) {
            res = Math.max(res, nums[i]);
        }

        for(int n : nums) {
            int tmp = curMax;
            curMax = Math.max(Math.max(n*curMax, n*curMin), n);
            curMin = Math.min(Math.min(n*tmp, n*curMin), n);

            res = Math.max(curMax, res);
        }
        return res;
    }
}
