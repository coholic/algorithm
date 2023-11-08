package Level2.캐시;

import java.util.Queue;
import java.util.LinkedList;

class Solution {
    private Queue<String> resultQueue = new LinkedList<>();

    public int solution(int cacheSize, String[] cities) {
        int time = 0;

        for(String city : cities) {
            time += getTime(cacheSize, city.toUpperCase());
        }

        return time;
    }

    private int getTime(int cacheSize, String city) {
        if(cacheSize == 0) return 5;
        if(resultQueue.contains(city)) {
            resultQueue.remove(city);
            resultQueue.offer(city);
            return 1;
        }
        if(resultQueue.size() < cacheSize) {
            resultQueue.offer(city);
            return 5;
        }
        resultQueue.poll();
        resultQueue.offer(city);
        return 5;
    }
}
