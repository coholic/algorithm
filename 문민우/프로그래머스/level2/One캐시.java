package level2;

import java.util.List;
import java.util.ArrayList;

public class One캐시 {
    public int solution(int cacheSize, String[] cities) {

        if (cacheSize == 0)
            return (5 * cities.length);

        int answer = 0;
        List<String> cache = new ArrayList<>();

        for (String city : cities) {

            city = city.toLowerCase();

            if (cache.contains(city)) {

                cache.remove(city);
                cache.add(city);
                answer++;

                continue;
            }

            if (cache.size() == cacheSize)
                cache.remove(0);

            cache.add(city);
            answer += 5;
        }

        return answer;
    }
}
