package level2.마법의엘리베이터;

public class Solution {
    public int solution(int storey) {

        int answer = 0;

        while (storey > 0) {

            int remainder = storey % 10;
            storey /= 10;

            if (remainder == 5) {

                if (storey % 10 >= 5) {

                    storey++;
                }

                answer += remainder;
            }

            else if (remainder > 5) {

                answer += (10 - remainder);
                storey++;
            }

            else {

                answer += remainder;
            }
        }

        return answer;
    }
}
