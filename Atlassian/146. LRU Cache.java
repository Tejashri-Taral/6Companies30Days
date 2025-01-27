class LRUCache {

    Map<Integer,Integer>mp;
    int cap;
    public LRUCache(int capacity) {
        mp=new LinkedHashMap<>();
        cap=capacity;
    }
    
    public int get(int key) {
        if(!mp.containsKey(key)) {
            return -1;
        }
        int val=mp.get(key);
        mp.remove(key);
        mp.put(key,val);
        return val;
    }
    
    public void put(int key, int value) {
        if(mp.containsKey(key)) {
            mp.remove(key);
            mp.put(key,value);
            return;
        }

        if(mp.size()==cap) {
            int rem=-1;
            for(int i:mp.keySet()) {
                rem=i;
                break;
            }
            mp.remove(rem);
        }
        mp.put(key,value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
