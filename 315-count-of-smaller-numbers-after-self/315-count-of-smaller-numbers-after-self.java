class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        List<Pair<Integer, Integer>> arr = new ArrayList();
        List<Integer> res = new ArrayList<Integer>(n);
        for(int i = 0; i < n; i++){
            Pair<Integer, Integer> pair = new Pair(nums[i], i);
            arr.add(pair);
            res.add(0);
        }
        
        mergeSort(arr, 0, n-1, res);
        
        return res;
    }
    
    void mergeSort(List<Pair<Integer, Integer>> arr, int left, int right, List<Integer> res){
        if(left < right){
            int mid = left + (right-left)/2;
            mergeSort(arr, left, mid, res);
            mergeSort(arr, mid + 1, right, res);
            merge(arr, left, right, res);
        }
    }
    
    void merge(List<Pair<Integer, Integer>> arr, int left, int right, List<Integer> res){
        int mid = left + (right-left)/2;
        int i = left, j = mid + 1;
        List<Pair<Integer, Integer>> tmp = new ArrayList();
        int rightCount = 0;
        while(i <= mid && j <= right){
            if(arr.get(i).getKey() <= arr.get(j).getKey()){
                int count = res.get(arr.get(i).getValue());
                res.set(arr.get(i).getValue(), count + rightCount);
                tmp.add(arr.get(i));
                i++;
            }
            else{
                rightCount++;
                tmp.add(arr.get(j));
                j++;
            }
        }
        
        while(i <= mid){
            int count = res.get(arr.get(i).getValue());
            res.set(arr.get(i).getValue(), count + rightCount);
            tmp.add(arr.get(i));
            i++;
        }
        
        while(j <= right){
            tmp.add(arr.get(j));
            j++;
        }
        
        for(i = left; i <= right; i++){
            arr.set(i, tmp.get(i-left));
        }
    }
}