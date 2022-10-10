class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        List<Integer> res = new ArrayList();
        for(int i = 0; i < n; i++){
            int index = Math.abs(nums[i]);
            if(nums[index-1] > 0) nums[index-1] = -nums[index-1];
        }
        
        for(int i = 0; i < n; i++){
            if(nums[i] > 0) {
                res.add(i+1);
            }
        }
        
        return res;
    }
}