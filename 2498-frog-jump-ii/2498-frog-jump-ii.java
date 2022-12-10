class Solution {
    public int maxJump(int[] stones) {
        int ans = stones[1] - stones[0];
        for(int i = 1; i < stones.length-1; i++){
            ans = Integer.max(ans, stones[i+1] - stones[i-1]);
        }
        
        return ans;
    }
}