class Solution {
    public int maxChunksToSorted(int[] arr) {        
        int ans = 0;
        int max = -1;
        for(int i = 0; i < arr.length; i++){
            max = Integer.max(max, arr[i]);
            if(max == i){
                ans++;
                // max = -1;
            }
        }
        
        return ans;
    }
}