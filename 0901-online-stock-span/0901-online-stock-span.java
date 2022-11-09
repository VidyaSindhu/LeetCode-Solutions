class StockSpanner {
    
    Stack<int[]> stack;
    int index;
    public StockSpanner() {
        this.stack = new Stack();
        this.index = 0;
    }
    
    public int next(int price) {
        if(stack.isEmpty()){
            stack.push(new int[]{price, index++});
            return index;
        }
        
        while(!stack.isEmpty() && stack.peek()[0] <= price){
            stack.pop();
        }
        int ans = stack.isEmpty() ? index + 1: index - stack.peek()[1];
        stack.push(new int[]{price, index++});
        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */