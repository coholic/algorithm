package level2;

public class 다음큰숫자 {
    public int solution(int n) {

        int answer = 0;

        String binaryStr = Integer.toBinaryString(n);  // 2진수 변환
        int count = 0;

        for(int i = 0; i < binaryStr.length(); i++) {

            if(binaryStr.charAt(i) == '1')  // 1의 개수 카운트
                count++;
        }

        while(true) {  // 다음 수를 2진수로 변환한 뒤, 1의 개수 카운트 반복

            n++;
            String binaryToCheck = Integer.toBinaryString(n);

            int check = 0;

            for(int i = 0; i < binaryToCheck.length(); i++) {

                if(binaryToCheck.charAt(i) == '1')
                    check++;
            }

            if(check == count) {
                answer = Integer.parseInt(binaryToCheck, 2);  // 2진수 -> 10진수
                break;
            }
        }

        return answer;
    }
}
