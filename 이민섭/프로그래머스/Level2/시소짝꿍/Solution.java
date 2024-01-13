package Level2.시소짝꿍;

import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

class Solution {
    private static Map<Double, Integer> resultMap = new HashMap<>();
    private final double[] valueArr = {1.0/2.0, 2.0/3.0, 3.0/4.0};

    public long solution(int[] weights) {
        long resultCount = 0;

        Arrays.sort(weights);

        for(int weight : weights) {
            double currentWeight = weight;

            double weightHalf = valueArr[0] * currentWeight;
            double weightTriple = valueArr[1] * currentWeight;
            double weightQuad = valueArr[2] * currentWeight;

            if(resultMap.containsKey(currentWeight)) resultCount += resultMap.get(currentWeight);
            if(resultMap.containsKey(weightHalf)) resultCount += resultMap.get(weightHalf);
            if(resultMap.containsKey(weightTriple)) resultCount += resultMap.get(weightTriple);
            if(resultMap.containsKey(weightQuad)) resultCount += resultMap.get(weightQuad);

            resultMap.put(currentWeight, resultMap.getOrDefault(currentWeight, 0) + 1);
        }

        return resultCount;
    }
}
