class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int right = 0, left = 0;
        int sum = 0;
        int ans = 0;
        while(right < costs.length){
            while(sum > coins){
                sum -= costs[left++];
            }
            sum += costs[right];
            if(sum <= coins){
                ans = Integer.max(ans, right - left + 1);
            }
            right++;
        }
        
        return ans;
    }
}