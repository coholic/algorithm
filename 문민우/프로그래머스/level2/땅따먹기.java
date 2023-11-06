package level2;

public class 땅따먹기 {
    private static final int COLUMN_COUNT = 4;
    private static int max;

    int solution(int[][] land) {

        for (int i = 1; i < land.length; i++) {

            land[i][0] += getMaxScoreOfPreviousRow(i, 0, land);
            land[i][1] += getMaxScoreOfPreviousRow(i, 1, land);
            land[i][2] += getMaxScoreOfPreviousRow(i, 2, land);
            land[i][3] += getMaxScoreOfPreviousRow(i, 3, land);
        }

        return getMaxTotalScore(land);
    }

    private int getMaxScoreOfPreviousRow(int currentRow, int currentColumn, int[][] land) {

        int previousRow = currentRow - 1;
        max = 0;

        for (int i = 0; i < COLUMN_COUNT; i++) {

            if (i == currentColumn)
                continue;

            max = Math.max(max, land[previousRow][i]);
        }

        return max;
    }

    private int getMaxTotalScore(int[][] land) {

        int endRow = land.length - 1;

        for (int i = 0; i < land[endRow].length; i++) {

            max = Math.max(max, land[endRow][i]);
        }

        return max;
    }
}
