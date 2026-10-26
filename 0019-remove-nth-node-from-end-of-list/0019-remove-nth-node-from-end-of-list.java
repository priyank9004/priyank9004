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
        // Create a dummy node to seamlessly handle edge cases (like removing the head)
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode fast = dummy;
        ListNode slow = dummy;
        
        // Move the fast pointer n steps ahead to establish the gap
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        
        // Move both pointers together until fast reaches the last node
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        
        // Relink the slow pointer to skip (delete) the target nth node
        slow.next = slow.next.next;
        
        // Return the actual head of the modified list
        return dummy.next;
    }
}
