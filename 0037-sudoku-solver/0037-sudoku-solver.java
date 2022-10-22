class Solution {
    public void solveSudoku(char[][] board) {
        helper(board);
    }
    
    
    boolean isValid(char[][] board, int x, int y, char val){
        for(int i = 0; i < 9; i++){
            if(board[i][y] != '.' && board[i][y] == val) return false;
            if(board[x][i] != '.' && board[x][i] == val) return false;
            if(board[3 * (x / 3) + i / 3][ 3 * (y / 3) + i % 3] != '.' && board[3 * (x / 3) + i / 3][3 * (y / 3) + i % 3] == val) return false;
        }
        
        return true;
    }
    boolean helper(char[][] board){        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                if(board[i][j] != '.') continue;
                
                for(char num = '1'; num <= '9'; num++){
                    if(!isValid(board, i, j, num)) continue;
                    
                    board[i][j] = num;
                    
                    if(helper(board)) return true;
                    
                    board[i][j] = '.';
                }
                return false;
            }
        }
        return true;
    }
}