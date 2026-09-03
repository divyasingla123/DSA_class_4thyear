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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head==null&&head.next==null)return null;
        ListNode temp=head;
        ListNode prevleft=null;
        for(int i=1;i<left;i++){
            prevleft=temp;
            temp=temp.next;
        }
        ListNode prev=null;
        ListNode curr=temp;
        ListNode agla=null;
        for(int i=0;i<=right-left;i++){
            agla=curr.next;
            curr.next=prev;
            prev=curr;
            curr=agla;
        }
        if(prevleft!=null){
            prevleft.next=prev;
        }
        else{
            head=prev;
        }
        temp.next=curr;
        return head;
    }
}