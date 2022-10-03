class Solution {
    public int minCost(String colors, int[] neededTime) {
        int n = colors.length();
        int right = 0;
        int ans = 0;
        while(right < colors.length()){
            int left = right;
            char curr = colors.charAt(right);
            int max = 0;
            int total = 0;
            while(right < n-1 && colors.charAt(right+1) == curr){
                total += neededTime[right];
                max = Integer.max(max, neededTime[right]);
                right++;
            }
            if(left != right){
                total += neededTime[right];
                max = Integer.max(max, neededTime[right]);
                ans += total - max;
            }
            right++;
        }
        
        return ans;
    }
}