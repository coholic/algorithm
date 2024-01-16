import java.util.*;
class Solution {
    public long solution(int[] w) {
        long answer = 0;
        Arrays.sort(w);
        int cnt =0;
        for (int i=0;i<w.length-1;i++){
            if(i >0 && w[i] == w[i-1]){
                cnt--;
                answer +=cnt;
                continue;
            }
            cnt = 0;
            for(int j=i+1;j<w.length;j++){
                if(w[i] == w[j] || 
                  w[i] * 4 == w[j]*3 ||
                  w[i] * 3 == w[j]*2 ||
                  w[i] * 2 == w[j] ){
                    cnt++;
                }
            }
            answer+=cnt;
        }
        return answer;
    }
}