class Solution {
    public boolean checkIfPangram(String sentence) {
        boolean[] chars = new boolean[26];
        for(char c: sentence.toCharArray()){
            chars[c-'a'] = true;
        }
        
        for(int i = 0; i < 26; i++){
            if(!chars[i]) return false;
        }
        
        return true;
    }
}