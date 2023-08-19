package level2;

import java.util.Arrays;

public class 귤고르기 {
    public int solution(int k, int[] tangerine) {  // 상자에 넣을 개수 k, 귤의 크기 tangerine

        int answer = 0;
        int[] count = new int[10000001];  // 1 <= 귤의 크기 <= 10000000

        for(int size : tangerine) {
            count[size]++;
        }

        Arrays.sort(count);

        int i = count.length - 1;

        while(k > 0) {

            k -= count[i];
            answer++;

            i--;
        }

        return answer;
    }
}
