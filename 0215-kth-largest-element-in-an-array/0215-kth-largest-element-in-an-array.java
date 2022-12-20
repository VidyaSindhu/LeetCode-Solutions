class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, k, 0, nums.length-1);
    }
    
    int quickSelect(int[] nums, int k, int low, int high){
        if(low >= high) return nums[low];
        
        // randomly choosing the pivot
        int pivotIndex = new Random().nextInt(high-low) + low;
        int pivot = nums[pivotIndex];
        
        // swaping the pivot with the last index of the subarray
        swap(nums, pivotIndex, high);
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
        
        if(nums.length - k == leftPtr) return nums[leftPtr];
        
        if(nums.length - k < leftPtr) return quickSelect(nums, k, low, leftPtr-1);
        
        return quickSelect(nums, k, leftPtr+1, high);
    }
    
    void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}