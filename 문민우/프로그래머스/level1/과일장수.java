package level2;

import java.util.Arrays;
import java.util.Collections;

public class 과일장수 {
    public int solution(int k, int m, int[] score) {

        int answer = 0;

        if(score.length < m)
            return answer;

        Integer[] scores = Arrays.stream(score).boxed().toArray(Integer[]::new);
        Arrays.sort(scores, Collections.reverseOrder());

        for(int i = 0; i <= scores.length - m; i += m) {
            answer += scores[i + (m - 1)] * m;
        }

        return answer;
    }
}
