class Solution {
    public int removeStones(int[][] stones) {
        int n = stones.length;
        int[] parents = new int[n];
        Arrays.fill(parents, -1);
        
        int[] setSize = new int[n];
        Arrays.fill(setSize, 1);
        for(int i = 0; i < n-1; i++){
            for(int j = i+1; j < n; j++){
                if(stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]){
                    union(parents, i, j, setSize);
                }
            }
        }
        
        int ans = 0;
        for(int i = 0; i < n; i++){
            if(parents[i] == -1){
                ans += setSize[i] - 1;
            }
        }
        
        return ans;
    }
    
    int find(int[] parents, int i){
        if(parents[i] == -1) return i;
        return parents[i] = find(parents, parents[i]);
    }
    
    void union(int[] parents, int x, int y, int[] setSize){
        int p1 = find(parents, x);
        int p2 = find(parents, y);
        
        if(p1 != p2){
            parents[p1] = p2;
            setSize[p2] += setSize[p1];
        }
    }
}