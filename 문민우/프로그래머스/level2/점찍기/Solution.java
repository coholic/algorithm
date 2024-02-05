package level2.점찍기;

public class Solution {
    public long solution(int k, int d) {

        long answer = 0;

        for (int i = 0; i <= d; i += k) {

            long max = (long) d * d;
            long x = (long) i * i;
            int distance = (int) Math.sqrt(max - x);
            answer += (distance / k) + 1;
        }

        return answer;
    }
}