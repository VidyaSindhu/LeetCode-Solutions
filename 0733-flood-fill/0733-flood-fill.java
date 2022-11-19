class Solution {
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        
        Deque<int[]> queue = new ArrayDeque();
        queue.offer(new int[]{sr,sc});
        
        int initial = image[sr][sc];
        image[sr][sc] = color;
        
        boolean[][] visited = new boolean[m][n];
        visited[sr][sc] = true;
        
        while(!queue.isEmpty()){
            int[] top = queue.poll();
            int x = top[0];
            int y = top[1];
            
            for(int[] dir: dirs){
                int newX = x + dir[0];
                int newY = y + dir[1];
                
                if(newX < 0 || newY < 0 || newX >= m || newY >= n 
                   || visited[newX][newY] || image[newX][newY] != initial) continue;
                
                image[newX][newY] = color;
                visited[newX][newY] = true;
                queue.offer(new int[]{newX, newY});
            }
        }
        
        return image;
    }
}