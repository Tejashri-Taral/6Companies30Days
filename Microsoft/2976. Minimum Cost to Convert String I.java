class Solution {

    void FloydWarshall(long adjMat[][],char[] original, char[] changed, int[] cost) {
        for(int i=0;i<original.length;i++) {
            int s=original[i]-'a';
            int t=changed[i]-'a';

            adjMat[s][t]=Math.min(adjMat[s][t],(long)cost[i]);
        }
        //FloydWarshall algo
        for(int k=0;k<26;k++) {
            for(int i=0;i<26;i++) {
                for(int j=0;j<26;j++) {
                    adjMat[i][j]=Math.min(adjMat[i][j],adjMat[i][k]+adjMat[k][j]);
                }
            }
        }
    }


    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
       long[][] distances = new long[26][26];
        for (int i = 0; i < 26; i++) {
            Arrays.fill(distances[i], Integer.MAX_VALUE);
        }

        FloydWarshall(distances, original, changed, cost);

        long ans = 0;
        for (int i = 0; i < source.length(); i++) {
            if (source.charAt(i) == target.charAt(i)) {
                continue;
            }

            if (distances[source.charAt(i) - 'a'][target.charAt(i) - 'a'] == Integer.MAX_VALUE) {
                return -1;
            } else {
                ans += distances[source.charAt(i) - 'a'][target.charAt(i) - 'a'];
            }
        }

        return ans;
    }
}
