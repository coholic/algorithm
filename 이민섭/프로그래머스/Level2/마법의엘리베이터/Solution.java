package Level2.마법의엘리베이터;

class Solution {
    public int solution(int storey) {
        return getCost(storey);
    }

    private int getCost(int value) {
        int cost = 0;
        int div = 10;

        while(value != 0) {
            int left = value % div;

            if(left > 5) {
                cost += (10 - left);
                value = value / div + 1;
                continue;
            }

            if(left < 5) {
                cost += left;
                value /= div;
                continue;
            }

            int nextLeft = value % 100;

            if(nextLeft > 50) {
                cost += (10 - left);
                value = value / div + 1;
                continue;
            }

            cost += left;
            value /= div;
            continue;

        }

        return cost;
    }
}