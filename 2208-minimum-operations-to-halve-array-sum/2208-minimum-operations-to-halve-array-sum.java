class Solution {
    public int halveArray(int[] nums) {
        int n = nums.length;
        PriorityQueue<Double> queue = new PriorityQueue(n, new Comparator<Double>() {
            public int compare(Double num1, Double num2){
                return num2.compareTo(num1);
            }
        });
        
        double sum = 0;
        for(int num : nums){
            sum += num;
            queue.offer((double)num);
        }
        int ans = 0;
        double target = sum/2;
        while(target < sum){
            ans++;
            double top = queue.poll();
            sum -= top;
            top = top/2;
            sum += top;
            queue.offer(top);
        }
        
        return ans;
        
    }
    
}