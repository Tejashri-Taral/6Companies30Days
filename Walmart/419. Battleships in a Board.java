class Solution {
    private void dfs(int i,int j,boolean vis[][],char mat[][]) {
        int n=mat.length;
        int m=mat[0].length;
        if(i<0 || i>=n || j<0 || j>=m || vis[i][j] || mat[i][j]=='.') {
            return;
        }
        vis[i][j]=true;
        int direction[][]={{-1,0},{0,1},{1,0},{0,-1}};
        for(int dir[]:direction) {
            dfs(i+dir[0],j+dir[1],vis,mat);
        }
    }
    public int countBattleships(char[][] board) {
        int n=board.length;
        int m=board[0].length;
        int count=0;
        boolean vis[][]=new boolean[n][m];
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(!vis[i][j] && board[i][j]=='X') {
                    count++;
                    dfs(i,j,vis,board);
                }
            }
        }
        return count;
    }
}
