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
        // PriorityQueue to store nodes, comparing based on node value
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        
        // Add all the heads of the lists to the priority queue
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                pq.add(lists[i]);
            }
        }
        
        // Dummy node to simplify the result construction
        ListNode temp = new ListNode(-1);
        ListNode current = temp;

        // Process the priority queue
        while (!pq.isEmpty()) {
            // Get the smallest node
            ListNode node = pq.poll();
            
            // Add it to the result list
            current.next = node;
            current = current.next;
            
            // If there is a next node in the current list, add it to the priority queue
            if (node.next != null) {
                pq.add(node.next);
            }
        }
        
        // Return the merged list, skipping the dummy node
        return temp.next;
    }
}
