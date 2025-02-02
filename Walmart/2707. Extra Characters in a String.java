class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        int n=dictionary.length;
        int count=0;
        for(int i=0;i<n;i++) {
            String curr=dictionary[i];
            if(!s.contains(curr)) {
                count++;
            }
        }
        return count;
    }
}
