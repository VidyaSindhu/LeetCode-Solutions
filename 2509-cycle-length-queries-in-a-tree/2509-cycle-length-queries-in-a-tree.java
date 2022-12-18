class Solution {
    public int[] cycleLengthQueries(int n, int[][] queries) {
        int[] res = new int[queries.length];
        for(int i = 0; i < queries.length; i++){
            Stack<Integer> p1 = getPath(queries[i][0]);
            Stack<Integer> p2 = getPath(queries[i][1]);
            
            while(!p1.isEmpty() && !p2.isEmpty() && p1.peek().equals(p2.peek())){
                p1.pop();
                p2.pop();
            }
            
            res[i] = p1.size() + p2.size() + 1;
        }
        return res;
    }
    
    Stack<Integer> getPath(int n){
        Stack<Integer> stack = new Stack();
        for(; n > 0; ){
            stack.push(n);
            if(n % 2 == 0) n /= 2;
            else n = (n-1)/2;
        }
        
        return stack;
    }
}