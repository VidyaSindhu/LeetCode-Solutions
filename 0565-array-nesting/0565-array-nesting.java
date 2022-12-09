class Solution {
    public int arrayNesting(int[] nums) {
        int n = nums.length;
        
        int ans = 0;
        for(int i = 0; i < n; i++){
            if(nums[i] == -1) continue;
            int steps = 0;
            int tmp = i;
            while(tmp != -1){
                steps++;
                int x = nums[tmp];
                nums[tmp] = -1;
                tmp = x;
            }
            
            ans = Integer.max(ans, steps-1);
        }
        
        return ans;
    }
    
    int dfs(int[] nums, int i, int depth){
        if(i == -1) return depth;
        int tmp = nums[i];
        nums[i] = -1;
        return dfs(nums, tmp, depth+1);
    }
}