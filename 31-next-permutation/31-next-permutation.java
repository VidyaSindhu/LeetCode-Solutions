class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        
        int peakIndex = -1;
        int right = n-1;
        while(right >= 1){
            if(nums[right-1] < nums[right]){
                peakIndex = right;
                break;
            }
            right--;
        }
        
        if(peakIndex == -1){
            reverse(nums, 0, nums.length-1);
            return;
        }
        int specialCase = peakIndex;
        for(int i = peakIndex; i < n; i++){
            if(nums[i] > nums[peakIndex-1] && nums[peakIndex] > nums[i]){
                specialCase = i;
                // break;
            }
        }
        swap(nums, peakIndex-1, specialCase);
        Arrays.sort(nums, peakIndex, n);

    }
    void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    void reverse(int[] nums, int left, int right){
        while(left < right){
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}