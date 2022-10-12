class Solution {
    public double largestTriangleArea(int[][] points) {
        double ans = 0;
        int n = points.length;
        for(int i = 0; i < n-2; i++){
            for(int j = i+1; j < n-1; j++){
                for(int k = j+1; k < n; k++){
                    ans = Double.max(calArea(points[i], points[j], points[k]), ans);
                }
            }
        }
        
        return ans;
    }
    
    double calArea(int[] p1, int[] p2, int[] p3){
        double area = Math.abs(p1[0] * (p2[1] - p3[1]) + p2[0] * (p3[1] - p1[1]) + p3[0] * (p1[1] - p2[1]));
        
        return area/2.0;
    }
}