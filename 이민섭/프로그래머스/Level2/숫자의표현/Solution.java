package Level2.숫자의표현;

class Solution {
    public int solution(int n) {
        int count = 0;

        for(int i = 1; i <= n; i++) {
            int sum = 0;

            for(int j = i; j <= n; j++) {
                sum += j;
                if(sum > n) break;
                if(sum == n) count++;
            }
        }

        return count;
    }
}