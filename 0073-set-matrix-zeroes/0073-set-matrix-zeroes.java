class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        boolean firstRow = false;
        
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    if(i == 0){
                        firstRow = true;
                    }
                    else if(i > 0){
                        matrix[i][0] = 0;
                        matrix[0][j] = 0;
                    }
                }
            }
        }
        // for(int i = 0; i < m; i++){
        //     for(int j = 0; j < n; j++){
        //         System.out.print(matrix[i][j] + " ");
        //     }
        //     System.out.println("");
        // }
        
        for(int i = 1; i < m; i++){
            if(matrix[i][0] == 0){
                for(int j = 0; j < n; j++){
                    matrix[i][j] = 0;
                }
            }
        }
        
        for(int j = 0; j < n; j++){
            if(matrix[0][j] == 0){
                for(int i = 0; i < m; i++){
                    matrix[i][j] = 0;
                }
            }
        }
        if(firstRow){
            for(int j = 0; j < n; j++){
                matrix[0][j] = 0;
            }
        }
    }
    
}