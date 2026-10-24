/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 *     }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }
        
        // Dummy node acts as a permanent anchor before the modified head
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode groupPrev = dummy;
        
        while (true) {
            // Check if there are at least k nodes left to reverse
            ListNode kth = getKthNode(groupPrev, k);
            if (kth == null) {
                break;
            }
            
            // Track the start of the next group before we break links
            ListNode nextGroupStart = kth.next;
            
            // Reverse the current k-group segment
            ListNode prev = nextGroupStart;
            ListNode curr = groupPrev.next;
            
            while (curr != nextGroupStart) {
                ListNode tmp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = tmp;
            }
            
            // Connect groupPrev to the new head of the reversed group
            ListNode tmp = groupPrev.next;
            groupPrev.next = kth;
            groupPrev = tmp;
        }
        
        return dummy.next;
    }
    
    // Helper method to find the k-th node from a starting node
    private ListNode getKthNode(ListNode start, int k) {
        while (start != null && k > 0) {
            start = start.next;
            k--;
        }
        return start;
    }
}
