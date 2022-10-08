class Solution {
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {        
        int[] parents = new int[n];
        
        for(int i = 0; i < n; i++){
            parents[i] = i;
        }
        Arrays.sort(edgeList, (a, b) -> a[2]-b[2]);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> queries[a][2] - queries[b][2]);
        for(int i = 0; i < queries.length; i++){
            pq.offer(i);
        }
        boolean[] res = new boolean[queries.length];
        int curr = 0;
        int lastEdgeCost = 0;
        while(!pq.isEmpty()){
            int idx = pq.poll();
            
            int[] query = queries[idx];
            while(curr < edgeList.length && edgeList[curr][2] < queries[idx][2]){
                int p1 = find(edgeList[curr][0], parents);
                int p2 = find(edgeList[curr][1], parents);
                if(p1 != p2){
                    parents[p2] = p1;
                }
                lastEdgeCost = edgeList[curr][2];
                curr++;
            }
            
            int p1 = find(queries[idx][0], parents);
            int p2 = find(queries[idx][1], parents);
            
            if(p1 == p2 && lastEdgeCost < queries[idx][2]){
                res[idx] = true;
            }
        }
        
        
        return res;
    }
    
    int find(int i, int[] parents){
        if(parents[i] == i) return i;
        return parents[i] = find(parents[i], parents);
    }
}