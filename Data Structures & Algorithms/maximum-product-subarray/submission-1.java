class Solution {
    public int maxProduct(int[] nums) {
        int maxProd = Integer.MIN_VALUE;
        int curMax = 1;
        int curMin = 1;
        for(int i = 0; i<nums.length; i++) {
            if(nums[i] == 0) {
                curMax = curMin = 1;
                maxProd = Math.max(maxProd, 0);
                continue;
            }
            int tmp = curMax;
            curMax = Math.max(Math.max(curMax * nums[i], curMin * nums[i]), nums[i]);
            curMin = Math.min(Math.min(tmp * nums[i], curMin * nums[i]), nums[i]);

            maxProd = Math.max(curMax, maxProd);
        }
        return maxProd;
    }
}
