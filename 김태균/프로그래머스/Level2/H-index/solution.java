import java.util.*;
class Solution {
    public int solution(int[] citations) {
        Integer[] tmp = Arrays.stream(citations).boxed().toArray(Integer[]::new);
        Arrays.sort(tmp,Collections.reverseOrder());
        for (int i= tmp[0];i>=0;i--){
            // System.out.println(tmp[i]);
            int count =0;
            for (int j = 0;j<citations.length;j++){
                if (tmp[j] >= i){
                    count++;
                }
            }
            if (count >= i && citations.length - count <= i){
                System.out.println(i);
                return i;
            }
        }
        int answer = 0;
        return answer;
    }
}