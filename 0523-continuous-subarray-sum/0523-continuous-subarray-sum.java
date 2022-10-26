class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if(nums.length < 2) return false;
        
        HashMap<Integer, Integer> map = new HashMap();
        map.put(0, -1);
        
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            int rem = sum % k;
            if(map.get(rem) != null && i - map.get(rem) > 1){
                return true;
            }
            map.putIfAbsent(rem, i);
        }        
        return false;
    }
}