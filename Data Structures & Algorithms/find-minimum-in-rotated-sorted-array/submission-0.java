class Solution {
    public int findMin(int[] nums) {

        int res = nums[0];
        int l = 0;
        int r = nums.length-1;

        while(l <= r) {
            if(nums[l] < nums[r]) {
                return Math.min(res, nums[l]);
            } 
            int m = (l+r)/2;
            res = Math.min(res, nums[m]);
            if(nums[l] <= nums[m]) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return res;
    }
}
