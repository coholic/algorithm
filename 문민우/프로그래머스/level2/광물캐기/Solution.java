package level2.광물캐기;

import java.util.*;

public class Solution {
    public int solution(int[] picks, String[] minerals) {

        int answer = 0;
        int count = Math.min(minerals.length / 5 + 1, picks[0] + picks[1] + picks[2]);
        int[][] section = new int[count][3];
        int dp = 0, ip = 0, sp = 0;

        for (int i = 0; i < minerals.length; i += 5) {

            if (i / 5 == count)
                break;

            for (int j = i; j < i + 5; j++) {

                switch (minerals[j]) {

                    case "diamond":
                        dp += 1;
                        ip += 5;
                        sp += 25;
                        break;

                    case "iron":
                        dp += 1;
                        ip += 1;
                        sp += 5;
                        break;

                    case "stone":
                        dp += 1;
                        ip += 1;
                        sp += 1;
                }

                if (j == minerals.length - 1)
                    break;
            }

            section[i / 5][0] = dp;
            section[i / 5][1] = ip;
            section[i / 5][2] = sp;

            dp = ip = sp = 0;
        }

        Arrays.sort(section, (o1, o2) -> o2[2] - o1[2]);

        for (int i = 0; i < count; i++) {

            if (picks[0] != 0) {

                answer += section[i][0];
                picks[0]--;
            }

            else if (picks[1] != 0) {

                answer += section[i][1];
                picks[1]--;
            }

            else {

                answer += section[i][2];
                picks[2]--;
            }
        }

        return answer;
    }
}