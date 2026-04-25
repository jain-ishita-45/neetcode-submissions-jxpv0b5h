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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode cur=head,prev=null;
        int c=0;
        while(cur!=null)
        {
            c++;
            cur=cur.next;
        }
        int k=c-n;
        if(k==0) return head.next;
        cur=head;
        while(cur!=null && k!=0)
        {
            prev=cur;
            cur=cur.next;
            k--;

        }
        if (cur!=null)
        prev.next=cur.next;
        return head;
    }
}
