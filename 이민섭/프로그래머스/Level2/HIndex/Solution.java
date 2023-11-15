package Level2.HIndex;

import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);

        int max = citations[citations.length-1];
        int result = 0;

        for(int i = 0; i <= max; i++) {
            int lowCount = 0;
            int highCount = 0;

            for(int j = 0; j < citations.length; j++) {
                int value = citations[j];

                if(value <= i) lowCount++;
                if(value >= i) highCount++;
            }

            if(highCount >= i && lowCount <= i) result = Math.max(result, i);
        }

        return result;
    }
}