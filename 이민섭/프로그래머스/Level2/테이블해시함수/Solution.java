package Level2.테이블해시함수;

import java.util.Arrays;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        Arrays.sort(data, (o1, o2) ->
                (o1[col-1] != o2[col-1])?
                        Integer.compare(o1[col-1], o2[col-1]) : -1 * Integer.compare(o1[0], o2[0]));

        int sum = 0;

        for(int i = 0; i < data[row_begin-1].length; i++) {
            sum += (data[row_begin-1][i] % row_begin);
        }

        for(int i = row_begin; i < row_end; i++) {
            int value = 0;

            for(int j = 0; j < data[i].length; j++) {
                value += data[i][j] % (i+1);
            }

            sum ^= value;
        }

        return sum;
    }
}
