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
    public ListNode mergeKLists(ListNode[] lists) {
        ArrayList<Integer> ans=new ArrayList<>();
        for(ListNode lst:lists)
        {
            while(lst!=null)
            {
                ans.add(lst.val);
                lst=lst.next;
            }
           
        }
        Collections.sort(ans);
        ListNode dummy=new ListNode(-1);
        ListNode temp=dummy;
        for(int i=0;i<ans.size();i++)
        {
            ListNode nn=new ListNode(ans.get(i));
            temp.next=nn;
            temp=nn;
        }
        return dummy.next;

    }
}
