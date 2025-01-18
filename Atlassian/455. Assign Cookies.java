/* Intuition:
This is a greedy algorithm problem where we want to maximize the number of satisfied children. 
A child is satisfied if they receive a cookie that is at least as large as their greed factor. 
The intuition is to match the smallest possible cookie with each child, starting from the least 
greedy child, to maximize the number of satisfied children.
Approach:
1.First, sort both arrays (children's greed factors and cookie sizes) to enable efficient matching
2.Use two pointers: one for children and one for cookies
3.For each cookie, try to satisfy the current child:
        If the current cookie is big enough for the current child (cookies[cookie] >= children[child]), move to next child
        If the cookie is too small, move to next cookie and try again with same child
4.Continue until we run out of either cookies or children
5.Return the number of satisfied children (tracked by the child pointer)*/

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int child=0;
        for(int cookie=0; child<g.length && cookie<s.length ;cookie++) {
            if(s[cookie]>=g[child]) {
                child++;
            }
        }
        return child;
    }
}
