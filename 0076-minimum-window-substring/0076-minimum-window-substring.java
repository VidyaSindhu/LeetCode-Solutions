class Solution {
    public String minWindow(String s, String t) {
        int[] tFreq = new int[58];
        int[] sFreq = new int[58];
        
        for(char c : t.toCharArray()){
            tFreq[c-'A']++;
        }
        int left = 0, right = 0;
        String res = "";
        int best = Integer.MAX_VALUE;
        while(right < s.length()){
            sFreq[s.charAt(right)-'A']++;
            while(haveChars(tFreq, sFreq)){
                if(best > right - left + 1){
                    best = right - left + 1;
                    res = s.substring(left, right+1);
                }
                sFreq[s.charAt(left)-'A']--;
                left++;
            }
            right++;
        }
        
        if(s.length() < t.length()) return "";
        return res;
    }
    
    boolean haveChars(int[] t, int[] s){
        for(int i = 0; i < t.length; i++){
            if(s[i] < t[i]) return false;
        }
        
        return true;
    }
}