class Solution {
    public int longestPalindrome(String[] words) {
        HashMap<String, Integer> map = new HashMap();
        
        for(String word: words){
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        
        int ans = 0;
        
        boolean found = false;
        
        for(String word: map.keySet()){
            if(word.charAt(0) == word.charAt(1)){
                if(map.get(word) > 1){
                    int count = map.get(word)/2;
                    ans += count * 4;
                    if(map.get(word) % 2 == 1) found = true;
                }
                else found = true;
            }
            else if(map.containsKey(getReverse(word))){
                ans += 2 * Integer.min(map.get(word), map.get(getReverse(word)));
            }
        }
        
        return found ? ans + 2 : ans;
    }
    
    
    String getReverse(String word){
        return new StringBuilder(word).reverse().toString();
    }
}