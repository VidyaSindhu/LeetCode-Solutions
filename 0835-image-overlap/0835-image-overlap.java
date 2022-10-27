class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int maxOverlaps = 0;
        for(int xShift = 0; xShift < img1.length; xShift++){
            for(int yShift = 0; yShift < img2.length; yShift++){
                maxOverlaps = Integer.max(maxOverlaps, shiftAndCount(img1, img2, xShift, yShift));
                maxOverlaps = Integer.max(maxOverlaps, shiftAndCount(img2, img1, xShift, yShift));
            }
        }
        
        return maxOverlaps;
    }
    
    int shiftAndCount(int[][] M, int[][] R, int xShift, int yShift){
        int leftShiftOverLaps = 0, rightShiftOverLaps = 0;
        int rRow = 0;
        for(int mRow = yShift; mRow < M.length; mRow++){
            int rCol = 0;
            for(int mCol = xShift; mCol < M.length; mCol++){
                if(M[mRow][mCol] == 1 && M[mRow][mCol] == R[rRow][rCol]){
                    rightShiftOverLaps++;
                }
                if(M[mRow][rCol] == 1 && M[mRow][rCol] == R[rRow][mCol]){
                    leftShiftOverLaps++;
                }
                rCol++;
            }
            rRow++;
        }
        
        return Integer.max(leftShiftOverLaps, rightShiftOverLaps);
    }
}