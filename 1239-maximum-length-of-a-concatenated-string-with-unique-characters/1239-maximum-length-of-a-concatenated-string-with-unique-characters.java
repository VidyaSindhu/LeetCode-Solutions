class Solution {
    public int maxLength(List<String> arr) {
        int n = arr.size();
        int totalComb = 1 << (n+1);
        totalComb--;
        
        int maxLength = 0;
        
        int[] charFreq = new int[26];
        for(int i = 0; i < totalComb; i++){
            Arrays.fill(charFreq, 0);
            int len = 0;
            boolean found = true;
            for(int k = 0; k < arr.size(); k++){
                if(((i >> k) & 1) == 1){
                    int[] chars = getCharFreq(arr.get(k));
                    if(!isValid(charFreq, chars)){
                        found = false;
                        break;
                    }
                    
                    for(int j = 0; j < 26; j++){
                        charFreq[j] += chars[j];
                    }
                    len += arr.get(k).length();
                }
            }
            if(found){
                maxLength = Integer.max(maxLength, len);
            }
        }
        
        return maxLength;
    }
    
    boolean isValid(int[] original, int[] chars){
        for(int i = 0; i < 26; i++){
            if(chars[i] > 0 && original[i] > 0) return false;
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