class Solution {
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        int max = 0;
        for(int img1I = 0; img1I < n; img1I++){
            for(int img1J = 0; img1J < n; img1J++){
                for(int img2I = 0; img2I < n; img2I++){
                    for(int img2J = 0; img2J < n; img2J++){
                        int cur = dfs(img1, img2, img1I, img1J, img2I, img2J);
                        max = Integer.max(max, cur);
                        // System.out.println(cur + " " + img1I + " " + img1J + "  " + img2I + "  " + img2J);
                    }
                }
            }
        }
        
        return max;
    }
    
    int dfs(int[][] img1, int[][] img2, int x1, int y1, int x2, int y2){
        int count = 0;
        for(; x1 < img1.length && x2 < img2.length; x1++, x2++){
            for(int j1 = y1, j2 = y2; j1 < img1.length && j2 < img2.length; j1++, j2++){
                if(img1[x1][j1] == 1 && img1[x1][j1] == img2[x2][j2]){
                    count++;
                }
                // System.out.println(count + " " + x1 + " " + y1 + "  " + x2 + "  " + y2);
            }
            
        }
        return count;
    }
}