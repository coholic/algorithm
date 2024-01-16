import java.util.*;
class Solution {
    static ArrayList<Integer>[] li;
    static int[] visited;
    static int maxNum = 0;
    public int solution(int n, int[][] edge) {
        int answer = 0;
        li = new ArrayList[n+1];
        visited = new int[n+1];
        for(int i=1;i<n+1;i++){
            li[i] = new ArrayList<Integer>();
        }
        for(int i =0;i<edge.length;i++){
            li[edge[i][0]].add(edge[i][1]);
            li[edge[i][1]].add(edge[i][0]);
        }
        bfs(1);
        for(int i =1;i<n+1;i++){
            if (maxNum == visited[i]){
                answer++;
            }
        }      
        return answer;
    }
    public void bfs(int x){
        Queue<Integer> qu = new LinkedList();
        qu.offer(x);
        visited[x] = 1;
        while(!qu.isEmpty()){
            int tmp = qu.poll();
            for(int i =0;i<li[tmp].size();i++){
                int y = li[tmp].get(i);
                if (visited[y] !=0){
                    continue;
                }
                qu.offer(y);
                visited[y] = visited[tmp]+1;
                maxNum = Math.max(visited[y],maxNum);
            }
        }
    }
}