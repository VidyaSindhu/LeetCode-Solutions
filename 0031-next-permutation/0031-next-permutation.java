class Solution {
    public void nextPermutation(int[] nums) {
        int peakIdx = -1;
        int n = nums.length;
        for(int i = n-1; i >= 1; i--){
            if(nums[i] > nums[i-1]){
                peakIdx = i;
                break;
            }
        }
        
        if(peakIdx == -1){
            reverse(nums);
            return;
        }
        
        int idx = peakIdx;
        for(int i = peakIdx; i < n; i++){
            if(nums[i] > nums[peakIdx-1]){
                idx = i;
            }
        }
        
        swap(nums, peakIdx-1, idx);
        Arrays.sort(nums, peakIdx, n);
    }
    
    void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    
    void reverse(int[] nums){
        int i = 0, j = nums.length-1;
        while(i < j){
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}