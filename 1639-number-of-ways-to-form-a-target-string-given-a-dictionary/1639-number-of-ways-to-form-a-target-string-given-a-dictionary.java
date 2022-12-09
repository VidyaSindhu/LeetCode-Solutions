class Solution {
    int MOD = 1_000_000_007;
    Integer[][] dp;
    int[][] charFreq;
    public int numWays(String[] words, String target) {
        dp = new Integer[target.length()+1][words[0].length()+1];
        charFreq = new int[26][words[0].length()];
        for(String word: words){
            for(int i = 0; i < word.length(); i++){
                charFreq[word.charAt(i)-'a'][i]++;
            }
        }
        return numWays(words, 0, 0, target);
    }
    
    int numWays(String[] words, int i, int k, String target){
        if(i >= target.length()) return 1;
        if(k >= words[0].length()) return 0;
        
        if(dp[i][k] != null) return dp[i][k];
        
        long ans = numWays(words, i, k+1, target);
        
        if(charFreq[target.charAt(i)-'a'][k] > 0){
            ans += numWays(words, i+1, k+1, target) * (long)charFreq[target.charAt(i)-'a'][k];
            ans %= MOD;
        }
        
        return dp[i][k] = (int)ans;
    }
}