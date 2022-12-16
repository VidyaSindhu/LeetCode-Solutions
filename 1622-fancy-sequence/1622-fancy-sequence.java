class Fancy {
    class BIT{
        BIT(){
            val = 0;
            mul = 1;
            add = 0;
        }
        public long val;
        public long mul;
        public long add;
        
        public String toString(){
            return val + " " + mul + " " + add;
        }
    }
    
    int size = 0;
    int MOD = 1_000_000_007;
    BIT[] bit;
    public Fancy() {
        bit = new BIT[100000+5];
        for(int i = 0; i < bit.length; i++){
            bit[i] = new BIT();
        }
    }
    
    public void append(int val) {
        size++;
        bit[size].val = val;
    }
    
    public void addAll(int inc) {
        for(int i = size; i > 0; i -= (-i & i)){
            bit[i].add += inc;
            bit[i].add %= MOD;
        }
    }
    
    public void multAll(int m) {
        for(int i = size; i > 0; i -= (-i & i)){
            bit[i].add *= m;
            bit[i].add %= MOD;
            bit[i].mul *= m;
            bit[i].mul %= MOD;
        }
    }
    
    public int getIndex(int idx) {
        return getRangeSum(idx);
    }
    
    int getRangeSum(int idx){
        if(idx + 1 > size) return -1;
        long res = bit[idx+1].val;
        for(idx++; idx <= size; idx += (-idx & idx)){
            res *= bit[idx].mul;
            res %= MOD;
            res += bit[idx].add;
            res %= MOD;
        }
        
        return (int)res;
    }
}

/**
 * Your Fancy object will be instantiated and called as such:
 * Fancy obj = new Fancy();
 * obj.append(val);
 * obj.addAll(inc);
 * obj.multAll(m);
 * int param_4 = obj.getIndex(idx);
 */