class Solution {
    List<List<Integer>> result = new ArrayList<>();
    int target= 0;
    public List<List<Integer>> combinationSum(int[] nums, int target1) {
   
        List<Integer> cur = new ArrayList<>();
        target = target1;

        combSum(nums, 0, cur, 0);
        return result;
        
    }

    void combSum(int[] nums, int i, List<Integer> cur, int total) {
        if(total == target) {
            result.add(new ArrayList<>(cur));
            return;
        }

        if(i>=nums.length || total > target) {
            return;
        }

        cur.add(nums[i]);
        combSum(nums, i, cur, total + nums[i]);
        cur.remove(Integer.valueOf(nums[i]));

        combSum(nums, i+1, cur, total);
    }
}
