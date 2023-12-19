package level2.주차요금계산;

import java.util.*;

public class Solution {

    static Map<String, String> manage = new HashMap<>();
    static Map<String, String> inOrOut = new HashMap<>();
    static Map<String, Integer> totalTime = new TreeMap<>();

    public int[] solution(int[] fees, String[] records) {

        for (String record : records) {

            String time = record.split(" ")[0];
            String carNumber = record.split(" ")[1];
            String status = record.split(" ")[2];

            if (status.equals("OUT"))
                calculateTime(manage.get(carNumber), time, carNumber);

            else {
                manage.put(carNumber, time);
                inOrOut.put(carNumber, "IN");
            }

            if (!totalTime.containsKey(carNumber))
                totalTime.put(carNumber, 0);
        }

        List<Integer> list = new ArrayList<>();

        for (String carNumber : totalTime.keySet()) {

            if (inOrOut.get(carNumber).equals("IN")) {

                calculateTime(manage.get(carNumber), carNumber);
                list.add(calculateCost(totalTime.get(carNumber), fees[0], fees[1],
                        fees[2], fees[3]));
            }

            else
                list.add(calculateCost(totalTime.get(carNumber), fees[0], fees[1],
                        fees[2], fees[3]));
        }

        int[] answer = new int[list.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }

    public void calculateTime(String inTime, String outTime, String carNumber) {

        int totalHour = convertToInt(outTime.split(":")[0]) -
                convertToInt(inTime.split(":")[0]);
        int totalMinute = convertToInt(outTime.split(":")[1]) -
                convertToInt(inTime.split(":")[1]);

        totalMinute += totalHour * 60;

        totalTime.put(carNumber, totalTime.get(carNumber) + totalMinute);
        inOrOut.put(carNumber, "OUT");
    }

    public void calculateTime(String inTime, String carNumber) {

        int totalHour = 23 - convertToInt(inTime.split(":")[0]);
        int totalMinute = 59 - convertToInt(inTime.split(":")[1]);

        totalMinute += totalHour * 60;

        totalTime.put(carNumber, totalTime.get(carNumber) + totalMinute);
    }

    public int calculateCost(int minute, int basicTime, int basicCost,
                             int unitTime, int unitCost) {

        if (minute <= basicTime)
            return basicCost;

        else
            return basicCost + ((int) Math.ceil((double) (minute - basicTime) / (double)
                    unitTime) * unitCost);
    }

    public int convertToInt(String str) {
        return Integer.parseInt(str);
    }
}