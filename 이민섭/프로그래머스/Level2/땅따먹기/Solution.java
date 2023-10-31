package Level2.땅따먹기;

class Solution {
    int solution(int[][] land) {
        int score = Integer.MIN_VALUE;

        for(int i = 1; i < land.length; i++) {
            for(int j = 0; j < 4; j++) {
                int maxValue = Integer.MIN_VALUE;

                for(int m = 0; m < 4; m++) {
                    if(j == m) continue;

                    maxValue = Math.max(maxValue, land[i-1][m]);
                }

                land[i][j] += maxValue;
            }
        }

        for(int i = 0; i < 4; i++) {
            score = Math.max(score, land[land.length-1][i]);
        }

        return score;
    }
}