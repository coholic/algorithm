package Level2.의상;

import java.util.Map;
import java.util.HashMap;

class Solution {
    public static Map<String, Integer> resultMap = new HashMap<>();

    public int solution(String[][] clothes) {
        initResultMap(clothes);

        return getResult();
    }

    public int getResult() {
        int result = 1;

        for(Map.Entry<String, Integer> entry : resultMap.entrySet()) {
            result *= (entry.getValue() + 1);
        }

        return result - 1;
    }

    public void initResultMap(String[][] clothes) {
        for(String[] info : clothes) {
            String key = info[1];

            resultMap.put(key, resultMap.getOrDefault(key, 0) + 1);
        }
    }
}