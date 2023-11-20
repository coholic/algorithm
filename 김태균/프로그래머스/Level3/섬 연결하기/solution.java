import java.util.*;
class Solution {
    int[] parent;
    public int solution(int n, int[][] costs) {
        int answer = 0;
        int line = 0;
        parent = new int[n];
        for (int i =0; i<n;i++){
            parent[i] = i;
        }
        Arrays.sort(costs, (a,b) -> Integer.compare(a[2], b[2]));
        for (int i=0;i<costs.length;i++){
            if (line == n-1){
                break;
            }
            int u = find(costs[i][0]);
            int v = find(costs[i][1]);
            if (u !=v){
                if (u > v){
                    parent[u] = v;
                } else {
                    parent[v] = u;
                }
                answer += costs[i][2];
                line++;
            }
        }
        return answer;
    }
    public int find(int x){
        if (parent[x] == x){
            return x;
        } else {
            return find(parent[x]);
        }
    }
}
