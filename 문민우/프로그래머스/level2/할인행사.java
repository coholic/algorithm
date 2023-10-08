package level2;

import java.util.Map;
import java.util.HashMap;

public class 할인행사 {
    public int solution(String[] want, int[] number, String[] discount) {

        int answer = 0;

        Map<String, Integer> myMap = new HashMap<>();

        for (int i = 0; i < want.length; i++) {
            myMap.put(want[i], number[i]);
        }

        for (int i = 0; i <= discount.length - 10; i++) {

            Map<String, Integer> dMap = new HashMap<>();

            for (int j = 0; j < 10; j++) {
                dMap.put(discount[i + j], dMap.getOrDefault(discount[i + j], 0) + 1);
            }

            boolean flag = true;

            for (String key : myMap.keySet()) {
                if (myMap.get(key) != dMap.get(key)) {
                    flag = false;
                    break;
                }
            }

            if (flag)
                answer++;
        }

        return answer;
    }
}
