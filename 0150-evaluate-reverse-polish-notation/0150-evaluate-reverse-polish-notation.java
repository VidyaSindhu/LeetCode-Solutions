class Solution {
    public int evalRPN(String[] tokens) {
        int result = 0;
        String operators = "+-*/";
        
        Deque<String> stack = new ArrayDeque();
        
        for(String token : tokens){
            if(!operators.contains(token)){
                stack.push(token);
            }
            else{
                int index = operators.indexOf(token);
                int a = Integer.valueOf(stack.pop());
                int b = Integer.valueOf(stack.pop());
                switch(index){
                    case 0:
                        stack.push(String.valueOf(a+b));
                        break;
                    case 1:
                        stack.push(String.valueOf(b-a));
                        break;
                    case 2:
                        stack.push(String.valueOf(a*b));
                        break;
                    case 3:
                        stack.push(String.valueOf(b/a));
                        break;
                }
            }
        }
        
        return Integer.valueOf(stack.pop());
    }
}