class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap();
        
        for(String word : strs){
            String freq = getCharFreq(word);
            if(map.containsKey(freq)){
                map.get(freq).add(word);
            }
            else{
                map.put(freq, new LinkedList());
                map.get(freq).add(word);
            }
        }
        
        return new LinkedList(map.values());
    }
    
    String getCharFreq(String s){
        int[] chars = new int[26];
        StringBuilder sb = new StringBuilder();
        for(char c: s.toCharArray()){
            chars[c-'a']++;
        }
        for(int num: chars){
            sb.append(num);
            sb.append(" ");
        }
        
        return sb.toString();
    }
}