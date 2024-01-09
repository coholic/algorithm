package level2.호텔대실;

import java.util.*;

public class Solution {

    private static final int MAX_MINUTE = 24 * 60 + 10;
    private static final int HOUR = 60;
    private static final int CLEAN_TIME = 10;

    public int solution(String[][] book_time) {

        int answer = 0;
        int[] rooms = new int[MAX_MINUTE];

        for (String[] time : book_time) {

            rooms[convertToMinute(time[0])] += 1;
            rooms[convertToMinute(time[1]) + CLEAN_TIME] -= 1;
        }

        for (int i = 1; i < MAX_MINUTE; i++) {

            rooms[i] += rooms[i - 1];
            answer = Math.max(answer, rooms[i]);
        }

        return answer;
    }

    private int convertToMinute(String time) {

        String[] strArr = time.split(":");
        int hour = Integer.parseInt(strArr[0]);
        int minute = Integer.parseInt(strArr[1]);

        return hour * HOUR + minute;
    }
}
