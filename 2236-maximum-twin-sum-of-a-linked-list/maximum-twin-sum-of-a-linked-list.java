/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int pairSum(ListNode head) {
        int n = 0;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode prev = null;
        ListNode curr = slow;
        ListNode agla = curr.next;

        while (agla != null) {
            curr.next = prev;
            prev = curr;
            curr = agla;
            agla = agla.next;
        }
        curr.next = prev;
        int mx = -1;
        
        while(curr != null){
            int sum = head.val+curr.val;
            mx = Math.max(sum,mx);
            head = head.next;
            curr = curr.next;
        }
        return mx;
    }
}