class MyCalendarThree {
    TreeMap<Integer, Integer> map;
    public MyCalendarThree() {
        this.map = new TreeMap();
    }
    
    public int book(int start, int end) {
        map.put(start, map.getOrDefault(start, 0) + 1);
        map.put(end, map.getOrDefault(end, 0) - 1);
        
        int sum = 0;
        int ans = 0;
        for(int events : map.values()){
            sum += events;
            ans = Integer.max(ans, sum);
        }
        return ans;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(start,end);
 */