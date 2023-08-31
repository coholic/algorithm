package Level2.점프와순간이동;

public class Solution {
    public int solution(int n) {
        return getResult(n);
    }

    public int getResult(int n) {
        int result = 0;

        while(n != 0) {
            if(n % 2 == 0) {
                n /= 2;
                continue;
            }
            result++;
            n--;
        }

        return result;
    }
}
