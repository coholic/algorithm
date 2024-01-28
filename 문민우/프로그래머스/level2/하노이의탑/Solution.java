package level2.하노이의탑;

import java.util.*;

public class Solution {

    private static Queue<int[]> queue = new LinkedList<>();

    public int[][] solution(int n) {

        hanoi(n, 1, 2, 3);

        int[][] answer = new int[queue.size()][2];

        for (int i = 0; i < answer.length; i++) {

            int[] now = queue.poll();
            int start = now[0];
            int end = now[1];

            answer[i][0] = start;
            answer[i][1] = end;
        }

        return answer;
    }

    private void hanoi(int count, int start, int mid, int end) {

        if (count == 0)
            return;

        hanoi(count - 1, start, end, mid);
        queue.offer(new int[] {start, end});
        hanoi(count - 1, mid, start, end);
    }
}
