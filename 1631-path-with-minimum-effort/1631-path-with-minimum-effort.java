class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        
        if(m == 1){
            // if(n == 1) return heights[0][0];
            int max = 0;
            for(int i = 0; i < n; i++){
                max = Integer.max(max, Math.abs(heights[0][i] - heights[0][0]));
            }
            return max;
        }
        
        int[] dis = new int[m*n];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[0] = 0;
        int[][] dirs = {{1,0}, {-1, 0}, {0,1}, {0,-1}};
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0]-b[0]);
        
        pq.offer(new int[]{0, 0});
        
        while(!pq.isEmpty()){
            int effort = pq.peek()[0];
            int idx = pq.peek()[1];
            int x = idx/n;
            int y = idx - x * n;
            if(x == m-1 &&y == n-1) return effort;
            pq.poll();
            
            for(int[] dir: dirs){
                int newX = x + dir[0];
                int newY = y + dir[1];
                int newIdx = newX * n + newY;
                if(newX < 0 || newX >= m || newY < 0 || newY >= n) continue;
                int currEffort = Integer.max(effort, Math.abs(heights[x][y] - heights[newX][newY]));
                if(dis[newIdx] > currEffort){
                    dis[newIdx] = currEffort;
                    pq.offer(new int[]{dis[newIdx], newIdx});
                }
            }
        }
        
        return dis[m*n-1];
    }
}