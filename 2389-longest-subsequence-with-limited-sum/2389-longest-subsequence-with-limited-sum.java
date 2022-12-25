class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b-a);
        int n = queries.length;
        int[] res = new int[n];
        
        for(int i = 0; i < n; i++){
            int sum = 0;
            for(int num: nums){
                sum += num;
                pq.offer(num);
                while(!pq.isEmpty() && sum > queries[i]){
                    sum -= pq.poll();
                }
            }
            res[i] = pq.size();
            pq.clear();
        }
        return res;
    }
}