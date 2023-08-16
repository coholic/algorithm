package Level1.귤고르기;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;
import java.util.Collections;

class Solution {
    public static Map<Integer, Integer> resultMap = new HashMap<>();

    public int solution(int k, int[] tangerine) {
        mkResultMap(tangerine);
        List<Integer> valueList = getValueList();

        return getResultCount(k, valueList);
    }

    public int getResultCount(int limit, List<Integer> resultList) {
        int count = 0, sum = 0;

        for(int value : resultList) {
            sum += value;
            count++;
            if(sum >= limit) break;
        }

        return count;
    }

    public List<Integer> getValueList() {
        List<Integer> valueList = new LinkedList<>(resultMap.values());
        Collections.sort(valueList, Collections.reverseOrder());
        return valueList;
    }

    public void mkResultMap(int[] numbers) {
        for(int value : numbers) {
            resultMap.put(value, resultMap.getOrDefault(value, 0) + 1);
        }
    }
}
