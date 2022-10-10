class Solution {
    public int minStoneSum(int[] piles, int k) {
        int n = piles.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b-a);
        
        int total = 0;
        for(int pile : piles){
            total += pile;
            pq.offer(pile);
        }
        
        while(k --> 0){
            int top = pq.poll();
            total -= top/2;
            pq.offer(top - top/2);
        }
        
        return total;
    }
}