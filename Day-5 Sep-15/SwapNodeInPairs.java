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

// leetcode ques no 24
https://leetcode.com/problems/swap-nodes-in-pairs/

class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        while(head!=null && head.next!=null){

            //Node to be swapped
            ListNode first = head;
            ListNode second = head.next;

            //Swapping
            prev.next = second;
            first.next = second.next;
            second.next = first;
            
            // re positioning pointer 
            prev = first;
            head = first.next;
        }
        return dummy.next;
    }
}    
