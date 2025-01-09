class Solution {
    // Function to find maximum of each subarray of size k.
    public ArrayList<Integer> max_of_subarrays(int arr[], int k) {
        // Your code here
        ArrayList<Integer> result = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();
        
        for (int i = 0; i < arr.length; i++) {
            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }
            
            while (!deque.isEmpty() && arr[deque.peekLast()] < arr[i]) {
                deque.pollLast();
            }
            
            deque.offerLast(i);
            
            if (i >= k - 1) {
                result.add(arr[deque.peekFirst()]);
            }
        }
        
        return result;
    }
}
