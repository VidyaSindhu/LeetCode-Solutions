class Solution {
    class Trie{
        Trie[] next;
        boolean isWord;
        Trie(){
            this.next = new Trie[26];
            this.isWord = false;
        }
        
        void addWord(String word, Trie t){
            for(char c: word.toCharArray()){
                if(t.next[c-'a'] == null){
                    t.next[c-'a'] = new Trie();
                }
                t = t.next[c-'a'];
            }
            t.isWord = true;
        }
        
    }
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    List<String> res;
    public List<String> findWords(char[][] board, String[] words) {
        int m = board.length;
        int n = board[0].length;
        
        
        res = new ArrayList();
        boolean[][] visited = new boolean[m][n];
        
        Trie t = new Trie();
        for(String word: words){
            t.addWord(word, t);
        }
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(t.next[board[i][j] - 'a'] != null){
                    StringBuilder sb = new StringBuilder();
                    sb.append(board[i][j]);
                    dfs(board, i, j, t.next[board[i][j] - 'a'], sb, visited);
                }
            }
        }
        
        return res;
    }
    
    void dfs(char[][] board, int x, int y, Trie t, StringBuilder sb, boolean[][] visited){
        if(t.isWord){
            res.add(new String(sb.toString()));
            t.isWord = false;
        }
        
        visited[x][y] = true;
        
        for(int[] dir: dirs){
            int newX = x + dir[0];
            int newY = y + dir[1];
            
            if(newX < 0 || newY < 0 || newX >= board.length || newY >= board[0].length 
               || visited[newX][newY] || t.next[board[newX][newY] - 'a'] == null) continue;
            
            sb.append(board[newX][newY]);
            dfs(board, newX, newY, t.next[board[newX][newY] - 'a'], sb, visited);
            sb.deleteCharAt(sb.length()-1);
        }
        visited[x][y] = false;
    }
}