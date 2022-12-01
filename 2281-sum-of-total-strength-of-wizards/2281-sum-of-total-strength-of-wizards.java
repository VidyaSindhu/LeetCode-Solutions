class Solution {
    public int totalStrength(int[] strength) {
        int MOD = 1_000_000_007;
        int n = strength.length;
        long[] prefix = new long[n+1];
        int[] fromLeft = new int[n];
        int[] fromRight = new int[n];
        
        Deque<Integer> stack = new ArrayDeque();
        
        
        for(int i = 0 ; i < n; i++){
            while(!stack.isEmpty() && strength[stack.peek()] >= strength[i]){
                stack.pop();
            }
            prefix[i+1] = (prefix[i] + strength[i])%MOD;
            
            fromLeft[i] = stack.isEmpty() ? 0 : stack.peek() + 1;
            stack.push(i);
        }
        for(int i = 1; i < n+1; i++){
            prefix[i] = (prefix[i] + prefix[i-1])%MOD;
            // prefix[i] %= MOD;
            // if(prefix[i] < 0) System.out.println("yes");
        }
        // for(int i = 1; i < n+1; i++){
        //     prefix[i] %= MOD;
        // }
        
        stack.clear();
        for(int i = n-1; i >= 0; i--){
            while(!stack.isEmpty() && strength[stack.peek()] > strength[i]){
                stack.pop();
            }
            fromRight[i] = stack.isEmpty() ? n - 1 : stack.peek() - 1;
            stack.push(i);
        }
        
        long ans = 0l;
        long left = 0l, right = 0l;
        for(int i = 0; i < n; i++){
            right = (prefix[fromRight[i] + 1] - prefix[i] + MOD)%MOD;
            right *= (long)(i - fromLeft[i] + 1);
            right %= MOD;
            if(fromLeft[i] <= 0){
                left = prefix[i];
            }
            else{
                left = (prefix[i] - prefix[fromLeft[i] - 1] +MOD) % MOD;
            }
            left *= (long)(fromRight[i] - i + 1);
            left%=MOD;
            
            long tmp = (right - left +MOD) % MOD;
            tmp *= (long)strength[i];
            tmp %= MOD;
            // ans %= MOD;
            ans += tmp;
            ans %= MOD;
        }
        
        return (int)ans;
    }
}