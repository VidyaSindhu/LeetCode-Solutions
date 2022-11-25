class Solution {
    public int sumSubarrayMins(int[] arr) {
        int MOD = 1000000007;
        Deque<Integer> leftStack = new ArrayDeque();
        Deque<Integer> rightStack = new ArrayDeque();
        
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];
        
        for(int i = 0; i < n; i++){
            while(!leftStack.isEmpty() && arr[leftStack.peek()] >= arr[i]){
                leftStack.pop();
            }
            left[i] = leftStack.isEmpty() ? i + 1 : i - leftStack.peek();
            leftStack.push(i);
        }
        
        for(int i = n-1; i >= 0; i--){
            while(!rightStack.isEmpty() && arr[rightStack.peek()] > arr[i]){
                rightStack.pop();
            }
            right[i] = rightStack.isEmpty() ? n - i : rightStack.peek() - i;
            rightStack.push(i);
        }
        
        long ans = 0L;
        for(int i = 0; i < n; i++){
            // number of times arr[i] is minimum towards its left and right
            ans += (long)left[i] * (long)right[i] * (long)arr[i];
            ans %= MOD;
        }
        
        return (int)ans;
    }
}