class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        int[] target = new int[nums.length];
        int right = 0;
        for(int i = 0; i < nums.length; i++){
            if(index[i] < right){
                shift(target, index[i], right);
            }
            target[index[i]] = nums[i];
            right++;
        }

        return target;
    }

    void shift(int[] arr, int left, int right){
        while(right > left){
            arr[right] = arr[right-1];
            right--;
        }
    }
}