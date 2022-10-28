class Solution {
    public boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE;
        int second = first; 
        
        //second - first - num
        for(int num : nums){
            if(first < num) return true;
            else if(second < num){
                first = num;
            }
            else second = Integer.min(second, num);
        }
        
        return false;
    }
}