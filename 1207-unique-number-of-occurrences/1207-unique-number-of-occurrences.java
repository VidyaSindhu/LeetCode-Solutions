class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Set<Integer> set = new HashSet();
        Map<Integer, Integer> map = new HashMap();
        
        for(int num: arr){
            int freq = map.getOrDefault(num, 0);
            freq++;
            map.put(num, freq);
        }
        
        for(int freq: map.values()){
            if(set.contains(freq)) return false;
            set.add(freq);
        }
        
        return true;
    }
}