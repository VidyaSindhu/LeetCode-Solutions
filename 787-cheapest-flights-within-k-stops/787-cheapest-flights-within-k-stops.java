class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[][] matrix = new int[n][n];
        for(int[] row : matrix){
            Arrays.fill(row, -1);
        }
        for(int[] flight: flights){
            matrix[flight[0]][flight[1]] = flight[2];
        }
        k++;
        int[][] dis = new int[n][k+1];
        for(int[] row : dis){
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dis[src][0] = 0;
        boolean[] visited = new boolean[n];
        visited[src] = true;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0]-b[0]);
        pq.offer(new int[]{0, 0, src});
        while(!pq.isEmpty()){
            int currDis = pq.peek()[0];
            int stops = pq.peek()[1];
            int node = pq.peek()[2];
            pq.poll();
            
            for(int i = 0; i < n; i++){
                if(matrix[node][i] != -1 && stops+1 <= k && dis[i][stops+1] > dis[node][stops] + matrix[node][i]){
                    dis[i][stops+1] = dis[node][stops] + matrix[node][i];
                    visited[i] = true;
                    pq.offer(new int[]{dis[i][stops+1], stops+1, i});
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for(int d: dis[dst]){
            min = Integer.min(min, d);
        }
        return !visited[dst] ? -1 : min; 
    }
}