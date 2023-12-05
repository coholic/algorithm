package Level2.롤케이크자르기;

import java.util.Map;
import java.util.HashMap;

class Solution {
    private static Map<Integer, Integer> resultMap = new HashMap<>();
    private static boolean[] visitArr;

    public int solution(int[] topping) {
        int count = 0;
        int length = 0;

        initResultMap(topping);
        initVisitArr();

        for(int key : topping) {
            int quantity = resultMap.get(key);

            if(quantity == 1) {
                resultMap.remove(key);
            }
            else {
                resultMap.put(key, quantity - 1);
            }

            if(!visitArr[key-1]) {
                length++;
                visitArr[key-1] = true;
            }

            if(length == resultMap.keySet().size()) count++;
        }

        return count;
    }

    private void initResultMap(int[] topping) {
        for(int value : topping) {
            resultMap.put(value, resultMap.getOrDefault(value, 0) + 1);
        }
    }

    private void initVisitArr() {
        visitArr = new boolean[10000];
    }
}