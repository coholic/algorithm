package Level1.콜라문제;

class Solution {
    public int solution(int a, int b, int n) {
        return getBottles(a, b, n);
    }

    public int getBottles(int require, int bottle, int myBottle) {
        if(myBottle < require) return 0;

        int bottleValue = myBottle / require * bottle;

        return bottleValue +
                getBottles(require, bottle, bottleValue + (myBottle % require));
    }
}
