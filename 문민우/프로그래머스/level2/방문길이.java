package level2;

import java.util.Set;
import java.util.HashSet;

public class 방문길이 {
    public int solution(String dirs) {

        int answer = 0;

        Set<String> set = new HashSet<>();  // 이동 경로
        int nowX = 0;
        int nowY = 0;

        for (int i = 0; i < dirs.length(); i++) {

            int nextX = nowX;
            int nextY = nowY;
            String road = "";

            switch (dirs.charAt(i)) {  // (0, 0) -> (0, 1) & (0, 1) -> (0, 0) => 0001 경로

                case 'U':
                    nextY++;
                    road += nowX;
                    road += nowY;
                    road += nextX;
                    road += nextY;
                    break;

                case 'D':
                    nextY--;
                    road += nextX;
                    road += nextY;
                    road += nowX;
                    road += nowY;
                    break;

                case 'R':
                    nextX++;
                    road += nowX;
                    road += nowY;
                    road += nextX;
                    road += nextY;
                    break;

                case 'L':
                    nextX--;
                    road += nextX;
                    road += nextY;
                    road += nowX;
                    road += nowY;
            }

            if (nextX < -5 || nextY < -5 || nextX > 5 || nextY > 5)
                continue;

            set.add(road);

            // 범위를 벗어나지 않았다면 갱신
            nowX = nextX;
            nowY = nextY;
        }

        answer = set.size();

        return answer;
    }
}
