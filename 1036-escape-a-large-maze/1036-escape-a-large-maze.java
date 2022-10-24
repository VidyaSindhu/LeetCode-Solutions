class Solution {
    int[][] dirs = {{1, 0}, {0, 1}, {-1, 0},{0, -1}};
    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        Set<String> visited = new HashSet();
        for(int[] blocks : blocked){
            visited.add(blocks[0] + " " + blocks[1]);
        }
        
        Deque<int[]> queue = new ArrayDeque();
        
        queue.offer(source);
        visited.add(source[0] + " " + source[1]);
        int limit = 20002, count = 1;
        while(!queue.isEmpty()){
            if(queue.size() > 205) return true;
            int[] top = queue.poll();
            if(top[0] == target[0] && top[1] == target[1]) return true;
            
            for(int[] dir : dirs){
                int x = top[0] + dir[0];
                int y = top[1] + dir[1];
                String pos = x + " " + y;
                if(!isValid(x, y) || visited.contains(pos)) continue;
                
                visited.add(x + " " + y);
                queue.offer(new int[]{x, y});
                count++;
            }
            
            if(count > limit) break;
        }
        if(count < limit) return false;
        queue.clear();
        visited.clear();
        for(int[] blocks : blocked){
            visited.add(blocks[0] + " " + blocks[1]);
        }
        limit = 20002;
        count = 1;
        queue.offer(target);
        visited.add(target[0] + " " + target[1]);
        while(!queue.isEmpty()){
            if(queue.size() > 205) return true;
            int[] top = queue.poll();
            if(top[0] == source[0] && top[1] == source[1]) return true;
            
            for(int[] dir : dirs){
                int x = top[0] + dir[0];
                int y = top[1] + dir[1];
                String pos = x + " " + y;
                
                if(!isValid(x, y) || visited.contains(pos)) continue;
                
                visited.add(x + " " + y);
                queue.offer(new int[]{x, y});
                count++;
                
            }
            
            if(count > limit) break;
        }
        if(count < limit) return false;
        return true;
    }
    
    boolean isValid(int x, int y){
        if(x < 0 || y < 0 || x >= 1e6 || y >= 1e6) return false;
        return true;
    }
}