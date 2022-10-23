class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] res = new int[2];
        for(int i = 0; i < nums.length; i++){
            int idx = Math.abs(nums[i]);
            if(nums[idx-1] < 0) res[0] = idx;
            else nums[idx-1] *= -1;
        }
        
        // for(int num: nums) System.out.println(num + " ");
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0) res[1] = i+1;
        }
        
        return res;
    }
}