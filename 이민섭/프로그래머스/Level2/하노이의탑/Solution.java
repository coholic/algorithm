package Level2.하노이의탑;

import java.util.List;
import java.util.LinkedList;

class Solution {
    private static List<int[]> resultList = new LinkedList<>();
    private static int[][] resultArr;

    public int[][] solution(int n) {
        hanoiTop(n, 1, 2, 3);
        mkResultArr();

        return resultArr;
    }

    private static void hanoiTop(int count, int current, int via, int to) {
        if(count == 1) {
            resultList.add(new int[]{current, to});
            return;
        }

        hanoiTop(count-1, current, to, via);
        resultList.add(new int[]{current, to});
        hanoiTop(count-1, via, current, to);
    }

    private static void mkResultArr() {
        resultArr = new int[resultList.size()][2];

        for(int i = 0; i < resultArr.length; i++) {
            resultArr[i] = resultList.get(i);
        }
    }
}
