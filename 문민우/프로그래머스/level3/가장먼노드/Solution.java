package level3.가장먼노드;

import java.util.*;

public class Solution {

    private static List<List<Integer>> graph;
    private boolean[] visited;
    private int answer = 0;

    public int solution(int n, int[][] edge) {

        graph = new ArrayList<>(n + 1);
        visited = new boolean[n + 1];

        for (int i = 0; i <= n; i++)
            graph.add(new ArrayList<>());

        for (int[] v : edge) {

            graph.get(v[0]).add(v[1]);
            graph.get(v[1]).add(v[0]);
        }

        bfs(n);

        return answer;
    }

    private void bfs(int n) {

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {1, 0});
        visited[1] = true;

        int max = Integer.MIN_VALUE;

        while (!queue.isEmpty()) {

            int[] now = queue.poll();
            int nowV = now[0];
            int nowDepth = now[1];

            if (max == nowDepth)
                answer++;

            if (max < nowDepth) {

                max = nowDepth;
                answer = 1;
            }

            for (int nextV : graph.get(nowV)) {

                if (visited[nextV])
                    continue;

                queue.offer(new int[] {nextV, nowDepth + 1});
                visited[nextV] = true;
            }
        }
    }
}