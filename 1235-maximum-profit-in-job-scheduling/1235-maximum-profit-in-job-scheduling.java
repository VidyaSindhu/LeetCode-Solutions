class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            // if(endTime[a] == endTime[b]) return startTime[];
            return endTime[a] - endTime[b];
        });
        
        for(int i = 0; i < endTime.length; i++){
            pq.offer(i);
        }
        TreeMap<Integer, Integer> dp = new TreeMap();
        
        dp.put(-1, 0);
        int ans = 0;
        while(!pq.isEmpty()){
            int idx = pq.poll();
            int max = dp.floorEntry(startTime[idx]).getValue() + profit[idx];
            if(max > dp.lastEntry().getValue()){
                dp.put(endTime[idx], max);
            }
            ans = Integer.max(ans, max);
        }
        
        return ans;
    }
}