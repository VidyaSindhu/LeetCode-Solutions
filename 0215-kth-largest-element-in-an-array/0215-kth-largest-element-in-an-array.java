class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length-1, k);
    }
    
    int quickSelect(int[] nums, int low, int high, int k){
        if(low >= high) return nums[low];
        
        int pivotIndex = high;
        int pivot = nums[pivotIndex];
        
        int leftPtr = low, rightPtr = high;
        while(leftPtr < rightPtr){
            while(nums[leftPtr] <= pivot && leftPtr < rightPtr){
                leftPtr++;
            }
            while(nums[rightPtr] >= pivot && leftPtr < rightPtr){
                rightPtr--;
            }
            swap(nums, leftPtr, rightPtr);
        }
        swap(nums, leftPtr, high);
        
        int pos = nums.length - k;
        if(pos == leftPtr) return nums[leftPtr];
        
        if(pos > leftPtr) return quickSelect(nums, leftPtr + 1, high, k);
        return quickSelect(nums, low, leftPtr - 1, k);
    }
    
    void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}