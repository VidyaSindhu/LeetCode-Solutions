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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head);
        int len = getLen(head);
        ListNode curr = dummy;
        while(len - k >= 0){
            len -= k;
            curr.next = reverse(curr.next, k);
            int n = k;
            while(curr != null && n --> 0){
                curr = curr.next;
            }
        }
        
        return dummy.next;
    }
    
    ListNode reverse(ListNode head, int k){
        ListNode curr = head;
        ListNode prev = null;
        while(curr != null && k --> 0){
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }
        head.next = curr;
        
        return prev;
    }
    
    int getLen(ListNode head){
        int len = 0;
        while(head != null){
            len++;
            head = head.next;
        }
        
        return len;
    }
}