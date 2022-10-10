class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> numFreq = new HashMap();
        
        for(int num : nums){
            numFreq.put(num, numFreq.getOrDefault(num, 0) + 1);
        }
        
        List<Integer>[] bucket = new ArrayList[nums.length + 1];
        
        for(Integer key : numFreq.keySet()){
            int value = numFreq.get(key);
            
            if(bucket[value] == null){
                bucket[value] = new ArrayList();
            }
            
            bucket[value].add(key);
        }
        
        int[] result = new int[k];
        int index = 0;
        for(int i = bucket.length-1; i >= 0; i--){
            if(bucket[i] != null){
                for(int val : bucket[i]){
                    result[index++] = val;
                    if(index == k)
                        return result;
                    }
            }
        }
        
        return result;
    }
}