package Level2.예상대진표;

class Solution {
    public int solution(int n, int a, int b) {
        return getMatch(n, a, b);
    }

    public int getMatch(int n, int a, int b) {
        int count = 1;
        int aIndex = getMyIndex(n, a);
        int bIndex = getMyIndex(n, b);
        n /= 2;

        while(aIndex != bIndex) {
            aIndex = getMyIndex(n, aIndex);
            bIndex = getMyIndex(n, bIndex);
            count++;
            n /= 2;
        }

        return count;
    }

    public int getMyIndex(int total, int index) {
        int length = total/2;

        for(int i = 1; i <= length; i++) {
            if(index == 2 * i || index == 2 * i - 1) return i;
        }

        return 0;
    }
}
