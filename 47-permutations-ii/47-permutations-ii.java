class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new ArrayList();
        Arrays.sort(nums);
        int n = nums.length;
        boolean[] taken = new boolean[n];
        helper(nums, new ArrayList(), taken);
        return res;
    }
    
    void helper(int[] nums, List<Integer> list, boolean[] taken){
        if(list.size() == nums.length){
            res.add(new ArrayList(list));
            return;
        }
        
        int curr = -11;
        for(int i = 0; i < nums.length; i++){
            if(!taken[i]){
                if(curr == -11){
                    curr = nums[i];
                    list.add(nums[i]);
                    taken[i] = true;
                    helper(nums, list, taken);
                    list.remove(list.size()-1);
                    taken[i] = false;
                }
                else if(curr != nums[i]){
                    curr = nums[i];
                    list.add(nums[i]);
                    taken[i] = true;
                    helper(nums, list, taken);
                    list.remove(list.size()-1);
                    taken[i] = false;
                }
            }
        }
    }
}