class Solution {
    int[] tree;
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> endTime[a] - endTime[b]);
        
        for(int i = 0; i < n; i++){
            heap.offer(i);
        }
        tree = new int[n+1];
        HashMap<Integer, Integer> map = new HashMap();
        TreeMap<Integer, Integer> treeMap = new TreeMap();
        for(int i = 0; i < n; i++){
            int max = 0;
            int idx = heap.poll();
            map.put(i, endTime[idx]);
            Integer floor = treeMap.floorKey(startTime[idx]);
            if(floor != null){
                max = getMax(treeMap.get(floor));
            }
            treeMap.put(endTime[idx], Integer.max(treeMap.getOrDefault(endTime[idx], 0), i));
            build(max + profit[idx], i);
        }
        
        
        return getMax(n-1);        
    }
    
    void build(int val, int x){
        x++;
        while(x < tree.length){
            tree[x] = Integer.max(tree[x], val);
            x += (-x & x);
        }
    }
    
    int getMax(int x){
        int ans = 0;
        x++;
        while(x > 0){
            ans = Integer.max(ans, tree[x]);
            x -= (-x & x);
        }
        return ans;
    }
    
}
