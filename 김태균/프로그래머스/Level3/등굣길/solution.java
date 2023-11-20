class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] graph = new int[n][m];
        for(int[] ob : puddles){
            graph[ob[1]-1][ob[0]-1] = -1;
        }
        graph[0][0] = 1;
        for (int i= 0;i<n;i++){
            for (int j =0;j<m;j++){
                if(graph[i][j]==-1){
                    graph[i][j]=0;
                    continue;
                }
                if(i!=0){
                    graph[i][j] += graph[i-1][j];
                }
                if(j!=0){
                    graph[i][j] += graph[i][j-1];
                }
                graph[i][j] %= 1000000007;
            }
        }
        System.out.println(graph[n-1][m-1]);
        return graph[n-1][m-1];
        
    }
}
