package Level2.가장큰정사각형찾기;

class Solution {
    private static int[][] dpArr;
    private static int distance = 0;

    public int solution(int[][] board) {
        initDpArr(board.length, board[0].length);
        mkDpArr(board);

        int length = 0;

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == 0) continue;

                while(checkValidation(j, i, length)) {
                    if(length == 0) {
                        distance = 1;
                        length++;
                        continue;
                    }

                    distance = Math.max(distance, ++length);
                }
            }
        }

        return distance * distance;
    }

    private static void initDpArr(int height, int width) {
        dpArr = new int[height][width];
    }

    private static void mkDpArr(int[][] board) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                int upperValue = 0;
                int leftValue = 0;
                int crossValue = 0;
                int currentValue = board[i][j];

                if(j-1 >= 0) leftValue = dpArr[i][j-1];
                if(i-1 >= 0) upperValue = dpArr[i-1][j];
                if(i-1 >= 0 && j-1 >= 0) crossValue = dpArr[i-1][j-1];

                dpArr[i][j] = upperValue + leftValue + currentValue - crossValue;
            }
        }
    }

    private static boolean checkValidation(int x, int y, int length) {
        if(length == 0) return true;
        int sum = getRangeSum(x, y, x + length, y + length);

        return sum == ((length+1) * (length+1));
    }

    private static int getRangeSum(int x1, int y1, int x2, int y2) {
        if(x2 >= dpArr[0].length || y2 >= dpArr.length) return 0;

        int leftUp = dpArr[y1][x1];
        int rightDown = dpArr[y2][x2];

        if(x1 == 0 && y1 == 0) return rightDown;
        if(y1 == 0) return dpArr[y2][x2] - dpArr[y2][x1-1];
        if(x1 == 0) return dpArr[y2][x2] - dpArr[y1-1][x2];
        return dpArr[y2][x2] - dpArr[y1-1][x2] - dpArr[y2][x1-1] + dpArr[y1-1][x1-1];
    }
}
