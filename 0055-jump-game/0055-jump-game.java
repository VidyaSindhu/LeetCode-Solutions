class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        if(n == 1) return true;
        
        int right = 0;
        while(right < n){
            int canReach = right + nums[right];
            int i = right;
            while(i < n && i < canReach){
                canReach = Integer.max(i + nums[i], canReach);
                i++;
            }
            // System.out.println()
            if(i >= n-1) return true;
            if(i == right) return false;
            right = canReach;
        }
        return true;
    }
}