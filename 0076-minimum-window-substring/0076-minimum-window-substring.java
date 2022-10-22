class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> targetMap = new HashMap();
        HashMap<Character, Integer> sMap = new HashMap();
        
        for(char c : t.toCharArray()){
            targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0;
        String res = "";
        int best = Integer.MAX_VALUE;
        while(right < s.length()){
            
            sMap.put(s.charAt(right), sMap.getOrDefault(s.charAt(right), 0) + 1);
            
            while(haveChars(targetMap, sMap)){
                if(best > right - left + 1){
                    best = right - left + 1;
                    res = s.substring(left, right+1);
                }
                sMap.put(s.charAt(left), sMap.get(s.charAt(left)) - 1);
                left++;
            }
            right++;
        }
        
        if(s.length() < t.length()) return "";
        return res;
    }
    
    boolean haveChars(HashMap<Character, Integer> t, HashMap<Character, Integer> s){
        for(char c : t.keySet()){
            if(!s.containsKey(c) || s.get(c) < t.get(c)) return false;
        }
        
        return true;
    }
}