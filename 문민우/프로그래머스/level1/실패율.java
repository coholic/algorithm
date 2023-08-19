package level1;

import java.util.HashMap;
import java.util.Map;

class 실패율 {
    public int[] solution(int N, int[] stages) {

        Map<Integer, Double> map = new HashMap<>();

        for(int i = 1; i <= N; i++) {

            double total = 0.0;
            double fail = 0.0;

            for(int j = 0; j < stages.length; j++) {

                if(i <= stages[j])
                    total++;

                if(i == stages[j])
                    fail++;
            }

            if(total == 0.0 && fail == 0.0)
                total = 1.0;

            map.put(i, fail / total);
        }

        int[] answer = new int[N];

        for(int i = 0; i < N; i++) {

            double max = -1.0;
            int rKey = 0;

            for(int key : map.keySet()) {

                if(max < map.get(key)) {

                    max = map.get(key);
                    rKey = key;
                }
            }

            answer[i] = rKey;
            map.remove(rKey);
        }

        return answer;
    }
}
