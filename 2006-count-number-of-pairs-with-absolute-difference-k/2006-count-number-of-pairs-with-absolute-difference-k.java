class Solution {
    public int countKDifference(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap();
        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        int ans = 0;
        for(int first: map.keySet()){
            if(map.containsKey(k + first)){
                ans += map.get(first) * map.get(k + first);
            }
            if(map.containsKey(first - k)){
                ans += map.get(first) * map.get(first - k);
            }
        }
        
        return ans/2;
    }
}