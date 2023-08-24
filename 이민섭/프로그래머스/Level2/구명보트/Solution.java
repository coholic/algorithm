package Level2.구명보트;

import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);

        return getCount(people, limit);
    }

    public int getCount(int[] people, int limit) {
        int boatCount = 0;
        int left = 0, right = people.length-1;

        while(left <= right) {
            int lightPerson = people[left];
            int heavyPerson = people[right];

            if(heavyPerson + lightPerson > limit) {
                boatCount++;
                right--;
                continue;
            }

            left++;
            right--;
            boatCount++;
        }

        return boatCount;
    }
}