package level2;

import java.util.Map;
import java.util.HashMap;

public class 영어끝말잇기 {
    public int[] solution(int n, String[] words) {

        int[] answer = new int[2];

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < words.length; i++) {

            if (i != 0) {

                String prev = words[i - 1];
                String cur = words[i];

                char last = prev.charAt(prev.length() - 1);
                char first = cur.charAt(0);

                if (map.containsKey(cur) || last != first) {

                    answer[0] = (i % n) + 1;
                    answer[1] = (i / n) + 1;

                    return answer;
                }
            }

            map.put(words[i], 1);
        }

        return answer;
    }
}
