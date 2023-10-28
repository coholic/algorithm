import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;
        int cnt = 1;
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < clothes.length;i++){
            System.out.println(clothes[i][1]);
            if (map.get(clothes[i][1]) == null){
                map.put(clothes[i][1],1);
            }
            else if (map.get(clothes[i][1]) != null){
                int v = map.get(clothes[i][1]);
                map.put(clothes[i][1],v+1);
            }
        }
        for( String key : map.keySet() ){
            cnt*=(map.get(key)+1);
        }
        cnt--;
        return cnt;
    }
}