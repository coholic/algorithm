package Level1.과일장수;

import java.util.Arrays;

class Solution {

    public static int[][] resultArr;

    public int solution(int k, int m, int[] score) {
        initResultArr(score.length/m, m);
        mkResultArr(m, score);

        return getResult(m);
    }

    public int getResult(int m) {
        int result = 0;

        for(int[] arr : resultArr) {
            int smallValue = arr[0];

            result += smallValue * m;
        }

        return result;
    }

    public void mkResultArr(int m, int[] score) {
        int start = score.length % m;
        int height = 0;

        Arrays.sort(score);

        for(int i = 0; i < resultArr.length; i++) {
            for(int j = 0; j < m; j++) {
                resultArr[i][j] = score[start++];
            }
        }
    }

    public void initResultArr(int height, int width) {
        resultArr = new int[height][width];
    }
}
