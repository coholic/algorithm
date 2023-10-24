import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class Solution {
    public int solution(String[][] clothes) {

        Map<String, Integer> clothesMap = new HashMap<>();

        for (String[] cloth : clothes) {
            if (!clothesMap.containsKey(cloth[1])) {
                clothesMap.put(cloth[1], 1);
            } else {
                int value = clothesMap.get(cloth[1]);
                clothesMap.replace(cloth[1], value + 1);
            }
        }

        // 2. 입지 않는 경우를 추가하여 모든 조합 계산하기
        Iterator<Integer> it = clothesMap.values().iterator();
        int answer = 1;

        while(it.hasNext())
            answer *= it.next().intValue() + 1;

        // 3. 아무종류의 옷도 입지 않는 경우 제외하기
        return answer - 1;

    }

}