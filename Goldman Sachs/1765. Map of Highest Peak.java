class Pair{
    int first,second;
    Pair(int first,int second) {
        this.first=first;
        this.second=second;
    }
}
class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int n=isWater.length;
        int m=isWater[0].length;
        int ans[][]=new int[n][m];
        boolean vis[][]=new boolean[n][m];
        Queue<Pair>q=new LinkedList<>();
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(isWater[i][j]==1) {
                    q.add(new Pair(i,j));
                    vis[i][j]=true;
                    ans[i][j]=0;
                }
            }
        }
        int delRow[]={0,-1,0,1};
        int delCol[]={1,0,-1,0};
        while(!q.isEmpty()) {
            int x=q.peek().first;
            int y=q.peek().second;
            q.remove();
            for(int i=0;i<4;i++) {
                int row=x+delRow[i];
                int col=y+delCol[i];
                if(row>=0 && row<n && col>=0 && col<m && vis[row][col]==false) {
                    ans[row][col]=ans[x][y]+1;
                    q.add(new Pair(row,col));
                    vis[row][col]=true;
                }
            }
        }
        return ans;
    }
}
