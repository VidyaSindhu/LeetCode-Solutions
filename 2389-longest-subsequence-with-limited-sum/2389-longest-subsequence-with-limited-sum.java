class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        int n = nums.length;
        int[] prefix = new int[n];
        Arrays.sort(nums);
        prefix[0] = nums[0];
        for(int i = 1; i < n; i++){
            prefix[i] = prefix[i-1] + nums[i];
        }
        
        int[] res = new int[queries.length];
        for(int i = 0; i < queries.length; i++){
            int insertionIndex = binarySearch(prefix, queries[i]);
            res[i] = insertionIndex;
        }
        
        return res;
    }
    
    int binarySearch(int[] nums, int target){
        int low = 0, high = nums.length-1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] <= target){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        
        return low;
    }
}