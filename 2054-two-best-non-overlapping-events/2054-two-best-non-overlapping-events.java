class Solution {
    public int maxTwoEvents(int[][] events) {
        List<int[]> list = new ArrayList();
        
        for(int[] event: events){
            list.add(new int[]{event[0], 1, event[2]});
            list.add(new int[]{event[1], -1, event[2]});
        }
        
        Collections.sort(list, (a, b) -> a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]);
        int max = Integer.MIN_VALUE/2;
        int ans = 0;
        for(int[] event : list){
            if(event[1] == 1){
                ans = Integer.max(ans, max + event[2]);
            }
            else{
                max = Integer.max(max, event[2]);
            }
        }
        
        return ans > max ? ans : max;
    }
}