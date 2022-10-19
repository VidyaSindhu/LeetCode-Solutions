class Solution {
    List<String> res = new ArrayList();
    public List<String> generateParenthesis(int n) {
        helper(2*n, 0, new StringBuilder());
        return res;
    }
    
    void helper(int n, int unclosedBrackets, StringBuilder sb){
        if(sb.length() == n){
            if(unclosedBrackets <= 0) res.add((new StringBuilder(sb)).toString());
            return;
        }

        if(unclosedBrackets > 0){
            sb.append(')');
            helper(n, unclosedBrackets-1, sb);
            sb.deleteCharAt(sb.length()-1);
        }
        sb.append('(');
        helper(n, unclosedBrackets+1, sb);
        sb.deleteCharAt(sb.length()-1);
    }
    
    
}