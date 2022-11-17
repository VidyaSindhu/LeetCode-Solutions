class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int area1 = (ax2-ax1) * (ay2 - ay1);
        int area2 = (bx2-bx1) * (by2 - by1);
        
        if(Integer.max(ay1, ay2) < Integer.min(by1, by2) || Integer.min(ay1, ay2) > Integer.max(by1, by2)){
            return area1 + area2;
        }
        if(Integer.max(ax1, ax2) < Integer.min(bx1, bx2) || Integer.min(ax1, ax2) > Integer.max(bx1, bx2)){
            return area1 + area2;
        }
        int commonArea = Integer.min(ax2, bx2) - Integer.max(ax1, bx1);
        commonArea *= (Integer.min(ay2, by2) - Integer.max(ay1, by1));
            
        return area1 + area2 - commonArea;
    }
}