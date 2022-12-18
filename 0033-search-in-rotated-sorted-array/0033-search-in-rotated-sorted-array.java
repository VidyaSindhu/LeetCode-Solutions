class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int low = 0, high = n-1;
        int mid;
        while(low <= high){
            mid = low + (high - low)/2;
            if(mid > 0 && nums[mid] < nums[mid-1]){
                low = mid;
                break;
            }
            else if(nums[mid] >= nums[low] && nums[mid] > nums[high]){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        
        int pivot = low;
        low = 0;
        high = n-1;
        
        if(pivot > 0 && target > nums[high]){
            high = pivot-1;
        }
        else{
            low = pivot;
        }
        
        while(low <= high){
            mid = low + (high - low)/2;
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid] < target){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return -1;
        
    }
}