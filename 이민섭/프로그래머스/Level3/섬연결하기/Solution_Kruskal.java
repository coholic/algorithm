package Level3.섬연결하기;

import java.util.Arrays;

// 크루스칼 알고리즘을 활용하여 해결한 풀이
class Solution_Kruskal {
    private static int[] parents;

    public int solution(int n, int[][] costs) {
        initParents(n);
        Arrays.sort(costs, (o1, o2) -> Integer.compare(o1[2], o2[2]));

        return getMinCost(costs);
    }

    public int getMinCost(int[][] arr) {
        int minCost = 0;

        for(int i = 0; i < arr.length; i++) {
            int from = arr[i][0];
            int to = arr[i][1];
            int cost = arr[i][2];

            int p1 = findParent(from);
            int p2 = findParent(to);

            if(p1 != p2) {
                unionNode(from, to);
                minCost += cost;
            }
        }

        return minCost;
    }

    public void initParents(int length) {
        parents = new int[length];

        for(int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }
    }

    public void unionNode(int x1, int x2) {
        x1 = findParent(x1);
        x2 = findParent(x2);

        if(x1 < x2) {
            parents[x2] = x1;
            return;
        }
        parents[x1] = x2;
    }

    public int findParent(int x) {
        if(parents[x] == x) return x;
        return findParent(parents[x]);
    }
}
