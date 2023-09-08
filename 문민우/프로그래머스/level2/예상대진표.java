package level2;

public class 예상대진표 {
    public int solution(int n, int a, int b) {

        int answer = 0;

        while (n > 1) {  // 라운드 종료까지

            answer++;

            if (a % 2 == 1) {  // a: 홀수

                if (a + 1 == b)
                    break;

                a = (a + 1) / 2;  // 다음 라운드에서의 참가 번호

                if (b % 2 == 1)  // b: 홀수
                    b = (b + 1) / 2;  // 다음 라운드에서의 참가 번호

                else
                    b /= 2;
            }

            else {

                if (b % 2 == 1) {

                    if (b + 1 == a)
                        break;

                    b = (b + 1) / 2;
                }

                else
                    b /= 2;

                a /= 2;
            }

            n /= 2;  // 참가자 수 갱신
        }

        return answer;
    }
}
