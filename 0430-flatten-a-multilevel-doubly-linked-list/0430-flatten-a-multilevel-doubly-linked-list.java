/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        Node dummy = new Node();
        dummy.val = 0;
        dummy.next = head;
        Stack<Node> stack = new Stack();
        Node curr = dummy;
        while(curr != null){
            // System.out.println(curr.val);
            if(curr.child != null){
                if(curr.next != null){
                    stack.push(curr.next);
                    curr.next.prev = null;
                }
                
                Node child = curr.child;
                curr.next = child;
                child.prev = curr;
                curr.child = null;
                curr = child;    
            }
            else{
                if(!stack.isEmpty() && curr.next == null){
                    curr.next = stack.pop();
                    curr.next.prev = curr;
                }
                curr = curr.next;
            }
            
        }
        // curr = dummy;
        // while(curr != null){
        //     System.out.print(curr.val + " ");
        //     curr = curr.next;
        // } 
        return dummy.next;
    }
}