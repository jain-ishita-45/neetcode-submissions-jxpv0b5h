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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode cur1=list1, cur2=list2;
        ListNode dummy=new ListNode(-1);
        ListNode temp=dummy;
        while(cur1!=null && cur2!=null)
        {
            if(cur1.val<cur2.val)
            {
                 ListNode t=new ListNode(cur1.val);
                  temp.next=t;
                cur1=cur1.next;
            }
            else
            {
                ListNode t1=new ListNode(cur2.val);
                temp.next=t1;
                cur2=cur2.next;            
            }
            temp=temp.next;
            
            
        }

        if (cur1!=null)
        temp.next=cur1;
        if(cur2!=null)
        temp.next=cur2;
        return dummy.next;
    }
}