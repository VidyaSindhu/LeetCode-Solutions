class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<int[]> events = new ArrayList();
        convertToLineSweep(buildings, events);

        List<List<Integer>> res = new ArrayList();

        Collections.sort(events, (a, b) -> (a[0] == b[0]) ? a[1]-b[1] : a[0]-b[0]);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b-a);
        int prevMax = 0;
        maxHeap.offer(0);

        for(int[] event : events){
            if(event[1] < 0){
                maxHeap.offer(-event[1]);
            }
            else{
                maxHeap.remove(event[1]);
            }
            int currMax = maxHeap.peek();
            if(currMax != prevMax){
                res.add(Arrays.asList(event[0], currMax));
                prevMax = currMax;
            }
        }

        return res;
    }

    void convertToLineSweep(int[][] buildings, List<int[]> events){
        for(int[] building : buildings){
            events.add(new int[]{building[0], -building[2]});
            events.add(new int[]{building[1], building[2]});
        }
    }
}