package level3;

import java.util.Arrays;

public class 섬연결하기 {

    static int[] parent;

    public int solution(int n, int[][] costs) {

        int answer = 0;
        parent = new int[n];

        Arrays.sort(costs, (int[] c1, int[] c2) -> c1[2] - c2[2]);

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int[] edge : costs) {

            int from = edge[0];
            int to = edge[1];
            int cost = edge[2];

            int fromParent = findParent(from);
            int toParent = findParent(to);

            if (fromParent == toParent)
                continue;

            answer += cost;
            parent[toParent] = fromParent;
        }

        return answer;
    }

    private int findParent(int node) {

        if (parent[node] == node)
            return node;

        return parent[node] = findParent(parent[node]);
    }
}