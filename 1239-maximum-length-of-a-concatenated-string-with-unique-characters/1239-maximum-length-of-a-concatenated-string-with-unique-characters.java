class Solution {
    public int maxLength(List<String> arr) {
        int n = arr.size();
        int totalComb = 1 << (n+1);
        totalComb--;
        
        int maxLength = 0;
        
        boolean[] charFreq = new boolean[26];
        for(int i = 0; i < totalComb; i++){
            Arrays.fill(charFreq, false);
            int len = 0;
            boolean found = true;
            for(int k = 0; k < arr.size(); k++){
                if(((i >> k) & 1) == 0) continue;
                
                int[] chars = getCharFreq(arr.get(k));

                if(!isValid(charFreq, chars)){
                    found = false;
                    break;
                }

                for(int j = 0; j < 26; j++){
                    charFreq[j] |= chars[j] > 0;
                }
                len += arr.get(k).length();
            }
            if(found){
                maxLength = Integer.max(maxLength, len);
            }
        }
        
        return maxLength;
    }
    
    boolean isValid(boolean[] original, int[] chars){
        for(int i = 0; i < 26; i++){
            if(chars[i] > 0 && original[i]) return false;
            else if(chars[i] > 1) return false;
        }
        
        return true;
    }
    
    int[] getCharFreq(String s){
        int[] res = new int[26];
        for(char c : s.toCharArray()){
            res[c-'a']++;
        }
        
        return res;
    }
}