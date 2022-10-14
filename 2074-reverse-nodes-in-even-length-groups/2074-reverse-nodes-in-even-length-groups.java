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
    public ListNode reverseEvenLengthGroups(ListNode head) {
        ListNode curr = head;
        int n = len(head);
        int j = 0;
        for(int i = 1; curr != null; i++){
            int k = i+1;
            if((n-j-1) <= i) {
                if((n-j-1) % 2 == 0) curr.next = reverse(curr.next, i);
                break;
            }
            if(i % 2 == 1) curr.next = reverse(curr.next, i);
            while(curr != null && k --> 0){
                curr = curr.next;
                j++;
            }
        }
        
        return head;
    }
    
    int len(ListNode head){
        int k = 0;
        while(head != null && k++ >= 0) head = head.next;
        
        return k;
    }
    
    ListNode reverse(ListNode head, int k){
        if(head == null) return null;
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = curr.next;
        ListNode tmp = null;
        while(next != null && k --> 0){
            tmp = next.next;
            next.next = curr;
            prev = curr;
            curr = next;
            next = tmp;
        }
        head.next = tmp;
        return curr;
    }
}