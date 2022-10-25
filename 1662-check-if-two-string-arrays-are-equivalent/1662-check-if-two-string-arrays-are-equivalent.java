class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int s1 = 0, s2 = 0, i = 0, j = 0;
        while(s1 < word1.length && s2 < word2.length){
            while(i < word1[s1].length() && j < word2[s2].length()){
                if(word1[s1].charAt(i) != word2[s2].charAt(j)) return false;
                i++;
                j++;
            }
            if(i == word1[s1].length()){
                i = 0;
                s1++;
            }
            if(j == word2[s2].length()){
                j = 0;
                s2++;
            }
        }
        if(s1 < word1.length || s2 < word2.length) return false;
        return true;
    }
}