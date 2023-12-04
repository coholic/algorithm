package level2.카펫;

public class Solution {
    public int[] solution(int brown, int yellow) {

        int[] answer = new int[2];

        int size = brown + yellow;

        for (int i = 3; i < size; i++) {
            int j = size / i;

            if (size % i == 0 && j >= 3) {
                int row = Math.min(i, j);
                int column = Math.max(i, j);

                if ((row - 2) * (column - 2) == yellow) {
                    answer[0] = column;
                    answer[1] = row;
                    break;
                }
            }
        }

        return answer;
    }
}
