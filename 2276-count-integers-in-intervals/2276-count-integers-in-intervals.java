class CountIntervals {
    TreeMap<Integer, Integer> map;
    int ans;
    public CountIntervals() {
        map = new TreeMap();
        ans = 0;
    }
    
    public void add(int left, int right) {
        if(map.floorKey(right) == null  || map.get(map.floorKey(right)) < left){
            map.put(left, right);
            ans += (right - left + 1);
        }
        else{
            int start = left;
            int end = right;
            while(!(map.floorKey(end) == null || map.get(map.floorKey(end)) < start)){
                int l = map.floorKey(right);
                int r = map.get(l);
                
                start = Integer.min(start, l);
                end = Integer.max(end, r);
                
                ans -= (r - l + 1);
                map.remove(l);               
            }
            
            map.put(start, end);
            ans += end - start + 1;
        }
    }
    
    public int count() {
        return ans;
    }
}

/**
 * Your CountIntervals object will be instantiated and called as such:
 * CountIntervals obj = new CountIntervals();
 * obj.add(left,right);
 * int param_2 = obj.count();
 */