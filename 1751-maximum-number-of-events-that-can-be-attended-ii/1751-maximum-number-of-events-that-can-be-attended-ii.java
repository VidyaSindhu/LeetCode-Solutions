class Solution {
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, (a, b) -> a[1] != b[1] ? a[1] - b[1] : a[0] - b[0]);
        
        int n = events.length;
        int[][] dp = new int[n][k+1];
        
        int ans = 0;
        for(int i = 0; i < n; i++){
            for(int j = 1; j <= k; j++){
                int index = binarySearch(events, events[i][0]);
                if (i - 1 >= 0) dp[i][j] = dp[i-1][j];
                if(index != -1){
                    dp[i][j] = Integer.max(dp[i][j], dp[index][j-1] + events[i][2]);
                    
                }
                else{
                    dp[i][j] = Integer.max(dp[i][j], events[i][2]);
                }
                ans = Integer.max(ans, dp[i][j]);
            }
        }
        return dp[n-1][k];
    }
    
    int binarySearch(int[][] events, int target){
        int low = 0, high = events.length-1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(events[mid][1] < target){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        
        return high;
    }
}