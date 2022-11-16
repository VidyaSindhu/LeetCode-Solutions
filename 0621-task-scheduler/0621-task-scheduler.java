class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for(char c: tasks){
            freq[c-'A']++;
        }
        Arrays.sort(freq);
        int f = 0;
        for(int k: freq){
            if(k == freq[25]){
                f++;
            }
        }
        
        return Integer.max(tasks.length, (freq[25] - 1) * (n + 1) + f);
    }
}