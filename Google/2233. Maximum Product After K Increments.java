class Solution {
    public int maximumProduct(int[] nums, int k) {
        long res = 1;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int a : nums)
            pq.add(a);
        while (k > 0) {
            int val = pq.poll();
            pq.add(++val);
            k--;
        }
        while (!pq.isEmpty())
            res = res * pq.remove() % 1000000007;

        return (int) (res);
    }
}
