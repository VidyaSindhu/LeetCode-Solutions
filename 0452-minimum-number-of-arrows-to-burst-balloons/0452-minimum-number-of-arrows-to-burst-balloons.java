class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> {
            if(a[1] < b[1]) return -1;
            else if(a[1] > b[1]) return 1;
            else return 0;
        });
        
        int ans = 1;
        int x = points[0][0];
        int y = points[0][1];
        
        for(int i = 1; i < points.length; i++){
            if(points[i][0] <= y) continue;
            else{
                ans++;
                x = points[i][0];
                y = points[i][1];
            }
        }
        
        return ans;
    }
}