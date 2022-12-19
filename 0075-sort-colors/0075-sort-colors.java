class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int left = 0, right = n-1;
        for(int i = 0; i < n; i++){
            if(nums[i] == 0 && i != left){
                swap(nums, i, left);
                i--;
                left++;
            }
            else if(nums[i] == 2 && i < right){
                swap(nums, i, right);
                right--;
                i--;
            }
        }
    }
    
    void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}