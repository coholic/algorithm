package Level3.정수삼각형;

class Solution {
    public static int[][] resultArr;

    public int solution(int[][] triangle) {
        initResultArr(triangle);
        mkResultArr(triangle);

        return resultArr[0][0];
    }

    public void mkResultArr(int[][] triangle) {
        int height = triangle.length - 1;

        for(int i = 0; i < triangle[height].length; i++) {
            resultArr[height][i] = triangle[height][i];
        }

        for(int i = height-1; i >= 0; i--) {
            for(int j = 0; j < resultArr[i].length; j++) {
                resultArr[i][j] = triangle[i][j] + Math.max(resultArr[i+1][j], resultArr[i+1][j+1]);
            }
        }
    }

    public void initResultArr(int[][] triangle) {
        int height = triangle.length;

        resultArr = new int[height][];

        for(int i = 0; i < resultArr.length; i++) {
            int width = triangle[i].length;

            resultArr[i] = new int[width];
        }
    }
}