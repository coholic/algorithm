package level2.전력망을둘로나누기;

import java.util.*;

public class Solution {
    private List<List<Integer>> graph;
    private boolean[] visited;
    private boolean[] check;

    public int solution(int n, int[][] wires) {
        int answer = n;
        graph = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] node : wires) {
            graph.get(node[0]).add(node[1]);
            graph.get(node[1]).add(node[0]);
        }
        check = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            check[i] = true;
            for (int node : graph.get(i)) {
                if (check[node])
                    continue;
                int total = bfs(n, i, 0);
                int cur = bfs(n, node, i);
                answer = Math.min(answer, Math.abs(total - 2 * cur));
            }
        }
        return answer;
    }

    private int bfs(int nodeCount, int node, int target) {
        Queue<Integer> queue = new LinkedList<>();
        visited = new boolean[nodeCount + 1];
        int count = 1;
        queue.offer(node);
        visited[node] = true;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int next : graph.get(now)) {
                if (next == target)
                    continue;
                if (visited[next])
                    continue;
                queue.offer(next);
                visited[next] = true;
                count++;
            }
        }
        return count;
    }
}