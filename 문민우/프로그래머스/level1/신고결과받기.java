package level1;

import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;

public class 신고결과받기 {
    public int[] solution(String[] id_list, String[] report, int k) {

        int[] answer = new int[id_list.length];

        Map<String, HashSet<String>> reportMap = new HashMap<>();
        Map<String, Integer> countMap = new HashMap<>();

        for (String id : id_list) {
            countMap.put(id, 0);
        }

        for (String r : report) {

            String reporter = r.split(" ")[0];
            String reported = r.split(" ")[1];

            if (reportMap.containsKey(reporter)) {  // 사용자가 신고를 한 번이라도 했을 경우

                if (!reportMap.get(reporter).contains(reported)) {  // 신고 대상을 신고한 적 없을 경우

                    reportMap.get(reporter).add(reported);
                    countMap.put(reported, countMap.get(reported) + 1);
                }
            }

            else {

                reportMap.put(reporter, new HashSet<String>() {{  // 익명 내부 클래스를 활용한 컬렉션 초기화
                    add(reported);
                }});
                countMap.put(reported, countMap.get(reported) + 1);
            }
        }

        for (String reported : countMap.keySet()) {

            int count = countMap.get(reported);

            if (count >= k) {

                for (int i = 0; i < id_list.length; i++) {

                    if (reportMap.get(id_list[i]) != null && reportMap.get(id_list[i]).contains(reported))  // 신고한 경험이 있고 해당 사용자를 신고했을 경우
                        answer[i]++;
                }
            }
        }

        return answer;
    }
}
