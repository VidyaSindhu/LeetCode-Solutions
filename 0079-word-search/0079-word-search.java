class Solution {
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1},{0, -1}};
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == word.charAt(0)){
                    if(dfs(board, i, j, word, 1)){
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
    
    boolean dfs(char[][] board, int x, int y, String word, int pos){
        if(pos >= word.length()) return true;
        
        char c = board[x][y];
        board[x][y] = '.';
        
        for(int[] dir: dirs){
            int newX = x + dir[0];
            int newY = y + dir[1];
            
            if(newX < 0 || newY < 0 || newX >= board.length || newY >= board[0].length
              || board[newX][newY] == '.') continue;
            
            if(board[newX][newY] == word.charAt(pos)) {
                if(dfs(board, newX, newY, word, pos+1))
                    return true;
            }
        }
        
        board[x][y] = c;
        return false;
    }
}