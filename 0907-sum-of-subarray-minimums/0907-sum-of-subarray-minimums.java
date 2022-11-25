class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int MOD = 1_000_000_007;
        Deque<Integer> stack = new ArrayDeque();
        int[] fromLeft = new int[n];
        int[] fromRight = new int[n];
        
        int right = 0;
        while(right < n){
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[right]){
                stack.pop();
            }
            fromLeft[right] = stack.isEmpty() ? right + 1: right - stack.peek();
            stack.push(right);
            right++;
        }
        
        stack.clear();
        for(int i = n-1; i >= 0; i--){
            while(!stack.isEmpty() && arr[stack.peek()] > arr[i]){
                stack.pop();
            }
            fromRight[i] = stack.isEmpty() ? n - i : stack.peek() - i;
            stack.push(i);
        }
        long ans = 0l;
        
        for(int i = 0; i < n; i++){
            ans += (long)arr[i] * (long)fromLeft[i] * (long)fromRight[i];
            ans %= MOD;
        }
        
        return (int)ans;
    }
}