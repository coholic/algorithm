package Level2.다음큰숫자;

class Solution {
    public int solution(int n) {
        int count = getCount(n);

        for(int i = n+1; ; i++) {
            int countValue = getCount(i);
            if(countValue == count) return i;
        }
    }

    public int getCount(int n) {
        int count = 0;

        while(true) {
            if(n == 0) break;
            if(n % 2 == 1) count++;
            n /= 2;
        }

        return count;
    }
}
