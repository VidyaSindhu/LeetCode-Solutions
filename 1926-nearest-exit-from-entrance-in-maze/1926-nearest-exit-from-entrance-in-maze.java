class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;
        Deque<int[]> queue = new ArrayDeque();
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        int idx = entrance[0] * n + entrance[1];
        queue.offer(new int[]{idx, 0});
        maze[entrance[0]][entrance[1]] = '+';
        while(!queue.isEmpty()){
            idx = queue.peek()[0];
            int x = idx/n;
            int y = idx - x * n;
            int steps = queue.peek()[1];
            
            queue.poll();
            // System.out.println(x + " " + y);
            for(int[] dir: dirs){
                int newX = x + dir[0];
                int newY = y + dir[1];
                int newIdx = newX * n + newY;
                if(newX < 0 || newY < 0 || newX >= m || newY >= n || maze[newX][newY] != '.') continue;
                if(newX == 0 || newX == m-1 || newY == 0 || newY == n-1) return steps+1;
                maze[newX][newY] = '+';
                queue.offer(new int[]{newIdx, steps+1});
            }
        }
        
        return -1;        
    }
}