package level1;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class 개인정보수집유효기간 {
    public int[] solution(String today, String[] terms, String[] privacies) {

        List<Integer> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();  // 약관 종류, 유효 기간 * 28

        for (String term : terms) {
            map.put(term.split(" ")[0], Integer.parseInt(term.split(" ")[1]) * 28);
        }

        int year = Integer.parseInt(today.split("\\.")[0]);
        int month = Integer.parseInt(today.split("\\.")[1]);
        int day = Integer.parseInt(today.split("\\.")[2]);

        for (int i = 0; i < privacies.length; i++) {

            String date = privacies[i].split(" ")[0];
            int valid = map.get(privacies[i].split(" ")[1]);

            // 오늘 일자 - 개인정보 수집 일자
            int diff = (year - Integer.parseInt(date.split("\\.")[0])) * 28 * 12
                    + (month - Integer.parseInt(date.split("\\.")[1])) * 28
                    + (day - Integer.parseInt(date.split("\\.")[2]));

            if (diff >= valid)
                list.add(i + 1);
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
