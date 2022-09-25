class Solution {
    public List<Integer> goodIndices(int[] nums, int k) {
        List<Integer> list = new ArrayList();
        // if(nums.length - 2 * k == 1) return list;
        int n = nums.length;
        int[] diff = new int[nums.length];
        diff[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            diff[i] = nums[i] - nums[i-1];
        }
        
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);
        for(int i = 1; i < n; i++){
            if(diff[i] <= 0){
                left[i] = left[i-1] + 1;
            }
        }
        diff[n-1] = nums[n-1];
        for(int i = n-2; i >= 0; i--){
            diff[i] = nums[i+1] - nums[i];
        }
        
        for(int i = n-2; i >= 0; i--){
            if(diff[i] >= 0){
                right[i] = right[i+1] + 1;
            }
        }
        // for(int i = 0; i < n; i++){
        //     System.out.println(left[i] + "  " + right[n-i-1]);
        // }
        
        for(int i = k; i < n-k; i++){
            if(left[i-1] >= k && right[i+1] >= k){
                list.add(i);
            }
        }
        
        return list;
    }
    
}