class Solution {
    public int longestString(int x, int y, int z) {
        int ans = Math.min(x,y);
        ans+=ans+1+z;
        if(x==y){
            ans-=1;
        }
        return ans*2;
    }
}
