package level2;

import java.util.Map;
import java.util.HashMap;

public class 의상 {
    public int solution(String[][] clothes) {

        int answer = 1;

        HashMap<String, Integer> clothingMap = new HashMap<>();

        for (String[] clothing : clothes) {

            if (clothingMap.containsKey(clothing[1]))
                clothingMap.put(clothing[1], clothingMap.get(clothing[1]) + 1);

            else
                clothingMap.put(clothing[1], 2);
        }

        for (String clothing : clothingMap.keySet()) {
            answer *= clothingMap.get(clothing);
        }

        answer--;

        return answer;
    }
}
