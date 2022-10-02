class Solution {
    public void conquer(ArrayList<Pair<Integer, Integer>> numPairs, int left, int mid, int right, int[] result){
        int count;
        boolean found = false;
        int size = right - left + 1;
        ArrayList<Pair<Integer, Integer>> newTempNumPairs = new ArrayList<>();
        int i = left, j = mid + 1;
        int ptr = 0;
        while(i <= mid && j <= right){
            if(numPairs.get(i).getKey() > numPairs.get(j).getKey()){
                result[numPairs.get(i).getValue()] += right - j + 1;
                newTempNumPairs.add(numPairs.get(i));
                i++;
            }
            else{
                newTempNumPairs.add(numPairs.get(j));
                j++;
            }
        }
        while(i <= mid){
            newTempNumPairs.add(numPairs.get(i));
            i++;
        }
        while(j <= right ){
            newTempNumPairs.add(numPairs.get(j));
            j++;
        }
        for(i = 0; i < size; i++){
            numPairs.set(i+left, newTempNumPairs.get(i));
        }
        
    }
    
    public void divide(ArrayList<Pair<Integer, Integer>> numPairs, int left, int right, int[] result){
        int mid = (left + right)/2;
        if(right > left){
            divide(numPairs, left, mid, result);
            divide(numPairs, mid+1, right, result);
            conquer(numPairs, left, mid, right, result);
        }
    }
    public List<Integer> countSmaller(int[] nums) {
        int count = 0;
        int n = nums.length;
        int result[] = new int[nums.length];
        ArrayList<Pair<Integer, Integer>> numPairs = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            numPairs.add(new Pair(nums[i], i));
        }
        divide(numPairs, 0, n-1, result);

        List<Integer> list = new ArrayList<>();
  
        for(int i = 0; i < n; i++){
            list.add(result[i]);
        }
        return list;
    }
}