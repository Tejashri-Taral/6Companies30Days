class Pair{
    String s;
    int val;
    Pair(String s,int val) {
        this.s=s;
        this.val=val;
    }
}
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String>ans=new ArrayList<>();
        Map<String,Integer>mp=new HashMap<>();
        for(String s:words) {
            mp.put(s,mp.getOrDefault(s,0)+1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> 
            a.val == b.val ? a.s.compareTo(b.s) : b.val - a.val
        );

        for (String s : mp.keySet()) {
            pq.add(new Pair(s, mp.get(s)));
        }

        while (k-- > 0) {
            ans.add(pq.poll().s);
        }
        return ans;
    }
}
