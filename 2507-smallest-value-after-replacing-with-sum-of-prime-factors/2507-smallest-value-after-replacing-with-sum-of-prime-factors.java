class Solution {
    public int smallestValue(int n) {
        boolean[] prime = new boolean[1000000];
        
        for(int i = 2; i < prime.length; i++){
            if(!prime[i]){
                for(int j = 2; j * i < prime.length; j++){
                    prime[j * i] = true;
                }
            }
        }
        
        // for(int i = 2; i < 20; i++) System.out.println(prime[i] + " ");
        if(!prime[n]) return n;
        
        while(prime[n]){
            int tmp = helper(n, prime);
            if(n == tmp) return n;
            n = tmp;
        }
        
        return n;
    }
    
    int helper(int n, boolean[] prime){
        int sum = 0;
        for(int i = n-1; i >= 2; i--){
            if(prime[i]) continue;
            while(n % i == 0){
                sum += i;
                n /= i;
            }
        }
        // System.out.println(sum);
        return sum;
    }
}