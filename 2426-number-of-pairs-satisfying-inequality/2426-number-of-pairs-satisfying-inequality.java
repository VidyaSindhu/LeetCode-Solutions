class Solution {
    public long numberOfPairs(int[] nums1, int[] nums2, int diff) {
        int n = nums1.length;
    
        int[] sub = new int[n];
        for(int i = 0; i < n; i++){
            sub[i] = nums1[i] - nums2[i];
        }
        
        return mergeSort(sub, 0, n-1, diff);
    }
    
    long mergeSort(int[] arr, int left, int right, int diff){
        long count = 0;
        if(left < right){
            int mid = (left + right)/2;
            count = mergeSort(arr, left, mid, diff) + mergeSort(arr, mid + 1, right, diff);
            int i = left, j = mid + 1;
            while(j <= right){
                if(i <= mid && arr[i] <= arr[j] + diff){
                    count += right - j + 1;
                    i++;
                }
                else j++;
            }
            
            merge(arr, left, right);
        }
        return count;
    }
    
    void merge(int[] arr, int left, int right){
        int mid = (left + right)/2;
        int i = left, j = mid + 1, k = 0;
        int[] tmp = new int[right - left + 1];
        while(i <= mid && j <= right){
            if(arr[i] < arr[j]){
                tmp[k++] = arr[i++];
            }
            else{
                tmp[k++] = arr[j++];
            }
        }

        while(i <= mid){
            tmp[k++] = arr[i++];
        }

        while(j <= right){
            tmp[k++] = arr[j++];
        }

        for(i = left; i <= right; i++){
            arr[i] = tmp[i-left];
        }
    }
}