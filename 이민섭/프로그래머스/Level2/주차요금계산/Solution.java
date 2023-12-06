package Level2.주차요금계산;

import java.util.StringTokenizer;
import java.util.PriorityQueue;
import java.util.Map;
import java.util.HashMap;

class Solution {
    private static Map<String, Integer> resultMap = new HashMap<>();
    private static Map<String, Integer> costMap = new HashMap<>();
    private static PriorityQueue<String> nameQueue = new PriorityQueue<>();

    public int[] solution(int[] fees, String[] records) {
        StringTokenizer st;

        int basicTime = fees[0];
        int basicCost = fees[1];
        int overTime = fees[2];
        int overCost = fees[3];

        for(String record : records) {
            st = new StringTokenizer(record, " ");

            int time = convertTime(st.nextToken());
            String number = st.nextToken();
            String command = st.nextToken();

            if(!nameQueue.contains(number)) nameQueue.offer(number);

            if(command.equals("IN")) {
                resultMap.put(number, time);
                continue;
            }

            int startTime = resultMap.get(number);
            int gap = time - startTime;

            costMap.put(number, costMap.getOrDefault(number, 0) + gap);
            resultMap.remove(number);
        }

        for(Map.Entry<String, Integer> entry : resultMap.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();
            int gap = 60 * 23 + 59 - value;

            costMap.put(key, costMap.getOrDefault(key, 0) + gap);
        }

        return getResultArr(basicCost, basicTime, overCost, overTime);
    }

    private int convertTime(String time) {
        StringTokenizer st = new StringTokenizer(time, ":");

        int hour = Integer.parseInt(st.nextToken());
        int minute = Integer.parseInt(st.nextToken());

        return 60 * hour + minute;
    }

    private int getCost(int gap, int basicCost, int basicTime,
                        int overCost, int overTime) {
        if(gap <= basicTime) return basicCost;

        if((gap - basicTime) % overTime == 0) {
            return basicCost + (gap - basicTime)/overTime * overCost;
        }

        return basicCost + ((gap - basicTime)/overTime + 1) * overCost;
    }

    private int[] getResultArr(int basicCost, int basicTime,
                               int overCost, int overTime) {
        int[] resultArr = new int[nameQueue.size()];

        for(int i = 0; i < resultArr.length; i++) {
            String name = nameQueue.poll();
            int gap = costMap.get(name);

            resultArr[i] = getCost(gap, basicCost, basicTime, overCost, overTime);
        }

        return resultArr;
    }
}
