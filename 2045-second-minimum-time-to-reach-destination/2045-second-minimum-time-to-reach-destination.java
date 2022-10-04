class Solution {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        List<Integer>[] adj = new ArrayList[n+1];
        for(int i = 0; i < n+1; i++){
            adj[i] = new ArrayList();
        }

        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            adj[u].add(v);
            adj[v].add(u);
        }

        Deque<int[]> queue = new ArrayDeque();
        int[][] reachingTime = new int[n+1][2];
        
        for(int[] row: reachingTime){
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        
        int arrivals = 0;
        queue.offer(new int[]{1, 0});
        reachingTime[1][0] = 0;

        while(!queue.isEmpty()){
            int node = queue.peek()[0];
            int arrivalTime = queue.peek()[1];
            queue.poll();

            
            if((arrivalTime/change) % 2 == 1){
                arrivalTime += change - arrivalTime % change;
            }
            arrivalTime += time;
            for(int neighbor: adj[node]){
                
                if(arrivalTime < reachingTime[neighbor][0]){
                    reachingTime[neighbor][0] = arrivalTime;
                    queue.offer(new int[]{neighbor, arrivalTime});
                }
                else if(arrivalTime > reachingTime[neighbor][0] && arrivalTime < reachingTime[neighbor][1]){
                    if(neighbor == n) return arrivalTime;

                    reachingTime[neighbor][1] = arrivalTime;
                    queue.offer(new int[]{neighbor, arrivalTime});
                }
            }
        }
        return -1;
    }
}