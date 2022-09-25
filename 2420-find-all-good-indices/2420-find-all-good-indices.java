class Solution {
    public List<Integer> goodIndices(int[] nums, int k) {
        List<Integer> list = new ArrayList();
        int n = nums.length;
        
        int[] left = new int[n];
        Arrays.fill(left, 1);
        
        int[] right = new int[n];
        Arrays.fill(right, 1);
        
        for(int i = 1; i < n; i++){
            if(nums[i] - nums[i-1] <= 0){
                left[i] = left[i-1] + 1;
            }
        }
        
        for(int i = n-2; i >= 0; i--){
            if(nums[i+1] - nums[i] >= 0){
                right[i] = right[i+1] + 1;
            }
        }
        
        for(int i = k; i < n-k; i++){
            if(left[i-1] >= k && right[i+1] >= k){
                list.add(i);
            }
        }
        
        return list;
    }
    
}