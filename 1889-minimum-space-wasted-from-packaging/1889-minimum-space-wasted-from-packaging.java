class Solution {
    int MOD = 1_000_000_007;
    public int minWastedSpace(int[] packages, int[][] boxes) {
        Arrays.sort(packages);
        int n = packages.length;
        long totalSum = 0;
        
        for(int i = 0; i < n; i++){
            totalSum += packages[i];
        }
        
        for(int[] box: boxes){
            Arrays.sort(box);
        }
        
        long ans = Long.MAX_VALUE;
        for(int[] box: boxes){
            
            if(box[box.length-1] < packages[n-1]) continue;
            int last = 0;
            
            long waste = 0;
            for(int i = 0; i < box.length; i++){
                int ceil = ceil(packages, box[i]);
                if(ceil != -1){
                    long len = ceil - last + 1;
                    waste += len * box[i];
                    last = ceil+1;
                    if(ceil >= packages.length) break;
                }
            }
            
            ans = Long.min(ans, waste);
        }
        
        return (int)(ans >= Long.MAX_VALUE ? -1 : (ans - totalSum) % MOD);
    }
    
    int ceil(int[] nums, int target){
        int low = 0, high = nums.length-1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] <= target){
                low = mid + 1;
            }
            else high = mid - 1;
        }
        
        return high;
    }
}