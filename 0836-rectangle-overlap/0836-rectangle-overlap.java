class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int ax1 = rec1[0];
        int ay1 = rec1[1];
        int ax2 = rec1[2];
        int ay2 = rec1[3];
        
        int bx1 = rec2[0];
        int by1 = rec2[1];
        int bx2 = rec2[2];
        int by2 = rec2[3];
        if(Integer.max(ay1, ay2) <= Integer.min(by1, by2) || Integer.min(ay1, ay2) >= Integer.max(by1, by2)){
            return false;
        }
        if(Integer.max(ax1, ax2) <= Integer.min(bx1, bx2) || Integer.min(ax1, ax2) >= Integer.max(bx1, bx2)){
            return false;
        }
        
        return true;
    }
}