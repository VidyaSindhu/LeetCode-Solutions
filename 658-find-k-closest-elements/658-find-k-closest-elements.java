class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList();
        
        int low = 0, high = arr.length-k-1;
        
        while(low <= high){
            int mid = low + (high - low)/2;
            if(x - arr[mid] <= arr[mid + k] - x){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        
        for(int i = low; i < low + k; i++){
            res.add(arr[i]);
        }
        return res;        
    }
}