class Solution {
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int MOD = 1_000_000_007;
    public int countPaths(int[][] grid) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> grid[b[0]][b[1]] - grid[a[0]][a[1]]);
        
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                pq.offer(new int[]{i, j});
            }
        }
        
        long[][] dp = new long[m][n];
        for(long[] row: dp){
            Arrays.fill(row, 1l);
        }
        
        while(!pq.isEmpty()){
            int[] top = pq.poll();
            int x = top[0];
            int y = top[1];
            for(int[] dir: dirs){
                int newX = x + dir[0];
                int newY = y + dir[1];
                if(newX < 0 || newY < 0 || newX >= grid.length || newY >= grid[0].length) continue;
                
                if(grid[x][y] > grid[newX][newY]){
                    dp[newX][newY] = (dp[newX][newY] + dp[x][y]) % MOD;
                }
            }
        }
        long ans = 0;
        for(long row[]: dp){
            for(long num: row){
                ans = (ans + num) % MOD;
            }
        }
        
        return (int)ans;
    }
}