class Solution {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        Integer[] dp = new Integer[books.length+1];
        
        return helper(books, 0, shelfWidth, dp);
    }
    
    int helper(int[][] books, int pos, int shelfWidth, Integer[] dp){
        if(pos >= books.length) return 0;
        
        if(dp[pos] != null) return dp[pos];
        
        int height = books[pos][1];
        int minHeight = Integer.MAX_VALUE;
        int width = 0;
        int i = 0;
        for(i = pos; i < books.length && width + books[i][0] <= shelfWidth; i++){
            height = Integer.max(height, books[i][1]);
            minHeight = Integer.min(minHeight, height + helper(books, i+1, shelfWidth, dp));
            width += books[i][0];
        }
        
        return dp[pos] = minHeight;
    }
}