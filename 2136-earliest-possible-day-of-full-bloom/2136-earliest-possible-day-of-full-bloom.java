class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int n = plantTime.length;
        
        List<Integer> indices = new ArrayList();
        for(int i = 0; i < n; i++){
            indices.add(i);
        }
        
        Collections.sort(indices, (a, b) -> growTime[b] - growTime[a]);
        
        int curr = 0, max = 0;
        for(int idx: indices){
            int time = curr + plantTime[idx] + growTime[idx];
            max = Integer.max(time, max);
            curr += plantTime[idx];
        }
        return max;
    }
}