/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeNodes(ListNode head) {
        ListNode curr = head;
        
        
        while(curr != null){
            // System.out.println(curr.val);
            if(curr.next != null && curr.next.val != 0){
                curr.val += curr.next.val;
                curr.next = curr.next.next;
            }
            else{
                if(curr.next.val == 0 && curr.next.next == null){
                    curr.next = null;
                }
                curr = curr.next;
            }
            
        }
        
        return head;
    }
}