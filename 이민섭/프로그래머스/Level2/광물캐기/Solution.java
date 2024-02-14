package Level2.광물캐기;

import java.util.Arrays;

class Solution {
    private static int[][] resultArr;

    public int solution(int[] picks, String[] minerals) {
        int minCost = 0;

        initResultArr(picks, minerals);

        Arrays.sort(resultArr, (o1, o2) -> Integer.compare(o2[2], o1[2]));

        for(int height = 0; height < resultArr.length; height++) {
            if(picks[0] != 0) {
                picks[0]--;
                minCost += resultArr[height][0];
                continue;
            }

            if(picks[1] != 0) {
                picks[1]--;
                minCost += resultArr[height][1];
                continue;
            }

            if(picks[2] != 0) {
                picks[2]--;
                minCost += resultArr[height][2];
            }
        }

        return minCost;
    }

    private void initResultArr(int[] picks, String[] minerals) {
        int length = Math.min(picks[0] + picks[1] + picks[2], minerals.length/5 + 1);

        resultArr = new int[length][3];

        for(int index = 0; index < minerals.length; index++) {
            if(index/5 >= resultArr.length) break;

            String type = minerals[index];

            if(type.equals("diamond")) {
                resultArr[index/5][0] += 1;
                resultArr[index/5][1] += 5;
                resultArr[index/5][2] += 25;
                continue;
            }

            if(type.equals("iron")) {
                resultArr[index/5][0] += 1;
                resultArr[index/5][1] += 1;
                resultArr[index/5][2] += 5;
                continue;
            }

            resultArr[index/5][0] += 1;
            resultArr[index/5][1] += 1;
            resultArr[index/5][2] += 1;
        }
    }
}