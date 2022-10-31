class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        if(m == 1 || n== 1) return true;
        int row = m-1;
        int col = 0;
        while(row > -1){
            int i = row;
            int j = col;
            for(; i < m-1 && j < n-1; i++, j++){
                if(matrix[i][j] != matrix[i+1][j+1]) return false;
            }
            if(row == 0){
                col++;   
            }
            if(row > 0){
                row--;
            }
            else if(row == 0 && col == n-1) row--;
        }
        return true;
    }
}