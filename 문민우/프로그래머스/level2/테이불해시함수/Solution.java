package level2.테이불해시함수;

import java.util.*;

public class Solution {

    private static List<Integer> S;

    public int solution(int[][] data, int col, int row_begin, int row_end) {

        S = new ArrayList<>((row_end - row_begin) + 1);

        Arrays.sort(data, (int[] o1, int[] o2) -> {

            if (o1[col - 1] == o2[col - 1])
                return o2[0] - o1[0];

            return o1[col - 1] - o2[col - 1];
        });

        calMod(data, row_begin - 1, row_end - 1);

        int answer = 0;

        for (int s : S) {
            answer = answer ^ s;
        }

        return answer;
    }

    private void calMod(int[][] arr, int start, int end) {

        for (int i = start; i <= end; i++) {

            int sum = 0;

            for (int j = 0; j < arr[i].length; j++) {

                sum += (arr[i][j] % (i + 1));
            }

            S.add(sum);
        }
    }
}