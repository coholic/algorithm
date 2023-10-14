package level2;

public class 정수삼각형 {
    class Solution {
        public int solution(int[][] triangle) {

            for (int i = 1; i < triangle.length; i++) {
                triangle[i][0] = triangle[i - 1][0] + triangle[i][0];
                triangle[i][i] = triangle[i - 1][i - 1] + triangle[i][i];
            }

            for (int i = 2; i < triangle.length; i++) {

                for (int j = 1; j < triangle[i].length - 1; j++) {
                    triangle[i][j] += Math.max(triangle[i - 1][j - 1], triangle[i - 1][j]);
                }
            }

            int len = triangle.length - 1;
            int answer = triangle[len][0];

            for (int i = 1; i < triangle[len].length; i++) {
                if (answer < triangle[len][i])
                    answer = triangle[len][i];
            }

            return answer;
        }
    }
}
