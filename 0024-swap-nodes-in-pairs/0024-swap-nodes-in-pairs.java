class Solution {
    public ListNode swapPairs(ListNode head) {
        // Create a dummy node to hold the placeholder before head
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        // This pointer tracks the node right before the pair we want to swap
        ListNode prev = dummy;
        
        // Ensure there are at least two nodes left to swap
        while (prev.next != null && prev.next.next != null) {
            ListNode first = prev.next;
            ListNode second = prev.next.next;
            
            // Re-point the connections to execute the swap
            first.next = second.next;
            second.next = first;
            prev.next = second;
            
            // Move the prev pointer forward by two nodes for the next iteration
            prev = first;
        }
        
        return dummy.next;
    }
}
