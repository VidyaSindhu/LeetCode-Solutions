class Solution {
    public boolean equationsPossible(String[] equations) {
        int[] parents = new int[26];
        for(int i = 0; i < 26; i++){
            parents[i] = i;
        }
        
        for(String equation : equations){
            if(equation.charAt(1) == '!') continue;
            
            int a = find(parents, equation.charAt(0) - 'a');
            int b = find(parents, equation.charAt(3) - 'a');
            
            parents[b] = a;
        }
        
        for(String equation : equations){
            if(equation.charAt(1) != '!') continue;
            
            int a = find(parents, equation.charAt(0) - 'a');
            int b = find(parents, equation.charAt(3) - 'a');
            
            if(a == b) return false;
        }
        
        return true;
        
    }
    
    int find(int[] parents, int num){
        if(parents[num] == num) return num;
        return parents[num] = find(parents, parents[num]);
    }
    
    
}