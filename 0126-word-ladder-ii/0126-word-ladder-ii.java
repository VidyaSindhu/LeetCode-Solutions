class Solution {
    List<List<String>> res;
    int n;
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        n = wordList.size();
        res = new ArrayList();
        
        Deque<String> queue = new ArrayDeque();
        
        HashMap<String, Integer> visited = new HashMap();
        visited.put(beginWord, 0);
        
        queue.offer(beginWord);
        
        HashMap<String, List<String>> parents = new HashMap();
        parents.put(beginWord, null);
        
        while(!queue.isEmpty()){
            
            String parent = queue.poll();
            
            if(parent.equals(endWord)) break;
            
            for(int i = 0; i < n; i++){
                String word = wordList.get(i);
                if(!visited.containsKey(word)){
                    if(hasOneCharacterDiff(parent, word)){
                        visited.put(word, visited.get(parent) + 1);
                        queue.offer(word);
                        if(!parents.containsKey(word)){
                            parents.put(word, new ArrayList());
                        }
                        parents.get(word).add(parent);
                    }
                }
                else if(visited.get(word) == visited.getOrDefault(parent, 0) + 1 && hasOneCharacterDiff(parent, word)){
                    parents.get(word).add(parent);
                }
            }
        }
        if(parents.get(endWord) == null) return res;
        Deque<List<String>> q = new ArrayDeque();
        List<String> tmp = new ArrayList();
        tmp.add(0, endWord);
        q.offer(tmp);
        while(!q.isEmpty()){
            List<String> list = q.poll();
            if(list.get(0).equals(beginWord)){
                res.add(list);
            }
            else{
                for(String parent : parents.get(list.get(0))){
                    List<String> temp = new ArrayList(list);
                    temp.add(0, parent);
                    q.offer(temp);
                }
            }
        }
        
        return res;
    }
    
    boolean hasOneCharacterDiff(String a, String b){
        int count = 0;
        for(int i = 0; i < a.length(); i++){
            if(a.charAt(i) != b.charAt(i)) count++;
            if(count > 1) return false;
        }
        
        return true;
    }
}