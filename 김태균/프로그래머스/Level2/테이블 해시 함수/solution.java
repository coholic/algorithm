import java.util.*;
class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
    
        Arrays.sort(data, (o1,o2) -> o1[col-1] == o2[col-1] ? o2[0] - o1[0] : o1[col-1] - o2[col - 1]);
        
        int[] S = new int[row_end-row_begin+1];
        int idx = 0;
        for(int i =row_begin-1;i<row_end;i++){
            for(int j =0;j<data[i].length;j++){
                S[idx] += (data[i][j] % (i+1));
            }
            idx++;
        }
        
        int res = S[0];
        for(int i = 1;i<S.length;i++){
            res = res ^ S[i];
        }
        
        System.out.println(res);
        
        return res;
    }
}