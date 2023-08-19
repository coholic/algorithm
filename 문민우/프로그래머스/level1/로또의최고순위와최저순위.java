package level1;

public class 로또의최고순위와최저순위 {
    public int[] solution(int[] lottos, int[] win_nums) {

        int[] answer = new int[2];  // 최고, 최저 순위

        int[] winCheck = new int[46];  // 로또 당첨 번호와 0을 체크
        int correct = 0;  // 맞힌 번호

        for(int winNum : win_nums) {
            winCheck[winNum] = 1;
        }

        for(int lotto : lottos) {

            if(lotto == 0)  // 0번
                winCheck[0]++;
            else {

                if(winCheck[lotto] == 1)  // 맞혔을 경우
                    correct++;
            }
        }

        switch(correct) {  // 맞힌 개수를 통한 순위와 0번의 개수를 통해 종합 순위 결정

            case 0:
                answer[0] = 7 - winCheck[0];
                answer[1] = 6;

                if(answer[0] == 7)  // 0번도 없을 경우
                    answer[0] = 6;

                break;

            case 1:
                answer[0] = 6 - winCheck[0];
                answer[1] = 6;
                break;

            case 2:
                answer[0] = 5 - winCheck[0];
                answer[1] = 5;
                break;

            case 3:
                answer[0] = 4 - winCheck[0];
                answer[1] = 4;
                break;

            case 4:
                answer[0] = 3 - winCheck[0];
                answer[1] = 3;
                break;

            case 5:
                answer[0] = 2 - winCheck[0];
                answer[1] = 2;
                break;

            case 6:
                answer[0] = 1;
                answer[1] = 1;
        }

        return answer;
    }
}
