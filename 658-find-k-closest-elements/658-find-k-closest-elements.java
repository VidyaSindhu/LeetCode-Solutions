class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList();
        
        int low = 0, high = arr.length-1;
        
        while(low <= high){
            int mid = low + (high - low)/2;
            if(arr[mid] >= x){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        
        int pivot = high;
        low = pivot;
        high = pivot + 1;
        while((low >= 0 || high < arr.length) && k > 0){
            if(low >= 0 && high < arr.length){
                int left = Math.abs(arr[low] - x);
                int right = Math.abs(arr[high] - x);
                if(left <= right){
                    res.add(arr[low]);
                    low--;
                }
                else{
                    res.add(arr[high]);
                    high++;
                }
            }
            else if(low >= 0){
                res.add(arr[low]);
                low--;
            }
            else if(high < arr.length){
                res.add(arr[high]);
                high++;
            }
            k--;
        }
        Collections.sort(res);
        return res;        
    }
}