class Solution {
    public boolean checkIfPangram(String sentence) {
        Set<Integer> set = new HashSet();
        for(char c: sentence.toCharArray()){
            set.add((int)(c-'a'));
        }
        
        if(set.size() < 26) return false;
        return true;
    }
}