class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int rows = matrix.length;
        int cols = rows;
        
        if(rows == 1) return matrix[0][0];
        
        for(int i = rows-2; i >= 0; i--){
            for(int j = 0; j < cols; j++){
                if(j == 0){
                    matrix[i][j] = Integer.min(matrix[i+1][j], matrix[i+1][j+1]) + matrix[i][j];
                }
                else if(j == cols-1){
                    matrix[i][j] = Integer.min(matrix[i+1][j-1], matrix[i+1][j]) + matrix[i][j];
                }
                else{
                    int min = Integer.min(matrix[i+1][j-1], matrix[i+1][j]);
                    matrix[i][j] = Integer.min(min, matrix[i+1][j+1]) + matrix[i][j];
                }
            }
        }
        
        int res = Integer.MAX_VALUE;
        for(int j = 0; j < cols; j++){
            res = Integer.min(res, matrix[0][j]);
        }
        return res;
    }
}