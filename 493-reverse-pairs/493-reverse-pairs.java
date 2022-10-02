class Solution {
    public int reversePairs(int[] nums) {
        int ans = mergeSort(nums, 0, nums.length-1);
        return ans;
    }
    
    int mergeSort(int[] nums, int left, int right){
        int count = 0;
        if(left < right){
            int mid = (left + right)/2;
            count = mergeSort(nums, left, mid) + mergeSort(nums, mid + 1, right);
            int i = left, j = mid + 1;
            while(i <= mid){
                if(j <= right && nums[i]/2.0 > nums[j]){
                    count += mid - i + 1;
                    j++;
                }
                else i++;
            }
            merge(nums, left, right);
        }
        return count;
    }
    
    void merge(int[] nums, int left, int right){
        int[] tmp = new int[right-left+1];
        int mid = (left + right)/2;
        int i = left, j = mid + 1;
        int k = 0;
        while(i <= mid && j <= right){
            if(nums[i] < nums[j]){
                tmp[k++] = nums[i++];
            }
            else{
                tmp[k++] = nums[j++];
            }
        }
        
        while(i <= mid){
            tmp[k++] = nums[i++];
        }
        
        while(j <= right){
            tmp[k++] = nums[j++];
        }
        
        for(i = left; i <= right; i++){
            nums[i] = tmp[i-left];
        }
    }
}