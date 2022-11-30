class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        int[] freq = new int[2002];
        for(int num: arr){
            freq[num + 1000]++;
        }
        
        Arrays.sort(freq);
        for(int i = freq.length-1; i >= 1; i--){
            if(freq[i] == 0) break;
            if(freq[i] == freq[i-1]) return false;
        }
        
        return true;
    }
}