package Level2.점찍기;

class Solution {
    public long solution(int k, int d) {
        long count = 0;

        for(int x = 0; x <= d; x += k) {
            int value = (int)Math.sqrt((Math.pow(d,2) - Math.pow(x, 2)))/k;
            count += (value + 1);
        }

        return count;
    }
}