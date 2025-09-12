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

//leetcode ques no 19
https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/


class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Create a dummy node before head
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode first = dummy;
        ListNode second = dummy;

        // Move first pointer n+1 steps ahead
        for (int i = 0; i <= n; i++) {
            first = first.next;
        }

        // Move both until first reaches end
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        // Delete the nth node
        second.next = second.next.next;

        return dummy.next; // new head
    }
}
