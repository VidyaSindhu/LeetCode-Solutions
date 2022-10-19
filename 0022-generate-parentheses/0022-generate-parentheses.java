class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList();
        helper(2*n, 0, new StringBuilder(), res);
        return res;
    }
    
    void helper(int n, int unclosedBrackets, StringBuilder sb, List<String> res){
        if(sb.length() == n){
            if(unclosedBrackets <= 0) res.add((new StringBuilder(sb)).toString());
            return;
        }

        if(unclosedBrackets > 0){
            sb.append(')');
            helper(n, unclosedBrackets-1, sb, res);
            sb.deleteCharAt(sb.length()-1);
        }
        sb.append('(');
        helper(n, unclosedBrackets+1, sb, res);
        sb.deleteCharAt(sb.length()-1);
    }
    
    
}