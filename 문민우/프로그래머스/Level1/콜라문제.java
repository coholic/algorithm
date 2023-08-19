package Level1;

public class 콜라문제 {
    public int solution(int a, int b, int n) {  // 콜라를 받기 위한 조건의 빈 병 개수 a, 받을 수 있는 콜라의 개수 b, 현재 가지고 있는 빈 병 개수 n

        int answer = 0;

        while(n >= a) {
            answer += (n / a) * b;  // 받는 콜라의 개수
            n = (n / a) * b + (n % a);  // 받는 콜라의 개수 + a 개를 줄 수 있는 만큼 주고 남은 빈 병 개수
        }

        return answer;
    }
}
