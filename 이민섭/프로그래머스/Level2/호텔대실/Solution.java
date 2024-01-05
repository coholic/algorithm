package Level2.호텔대실;

import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;

class Solution {
    private static List<LinkedList<Integer>> resultList = new LinkedList<>();

    public int solution(String[][] book_time) {
        Arrays.sort(book_time, (o1, o2) -> o1[1].compareTo(o2[1]));

        for(String[] arr : book_time) {
            int startTime = convertToValue(arr[0]);
            int endTime = convertToValue(arr[1]);

            boolean flag = false;
            int index = 0;
            int maxValue = Integer.MIN_VALUE;

            for(int i = 0; i < resultList.size(); i++) {
                int roomEndTime = resultList.get(i).get(0) + 10;
                if(startTime < roomEndTime) continue;

                if(maxValue < roomEndTime) {
                    maxValue = roomEndTime;
                    index = i;
                    flag = true;
                }
            }

            if(flag) {
                resultList.get(index).add(0, endTime);
                continue;
            }

            if(!flag) {
                resultList.add(new LinkedList<>());
                resultList.get(resultList.size()-1).add(0, endTime);
            }
        }

        return resultList.size();
    }

    private int convertToValue(String time) {
        String[] infoArr = time.split(":");

        int hour = Integer.parseInt(infoArr[0]);
        int min = Integer.parseInt(infoArr[1]);

        return 60 * hour + min;
    }
}