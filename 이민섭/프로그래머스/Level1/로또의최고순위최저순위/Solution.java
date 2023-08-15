package Level1.로또의최고순위최저순위;

import java.util.Map;
import java.util.HashMap;

class Solution {
    public static Map<Integer, Integer> winMap = new HashMap<>(); // 나의 번호를 저장하기 위한 Map
    public static Map<Integer, Integer> myMap = new HashMap<>(); // 당첨 번호를 저장하기 위한 Map

    public int[] solution(int[] lottos, int[] win_nums) {
        initWinMap(win_nums); // lottos 배열에 저장된 내 로또 번호를 Map에 저장
        initMyMap(lottos); // 당첨 번호를 Map에 저장

        return getResultArr();
    }

    public int[] getResultArr() {
        int lowestResult = getLowestResult(); // 0을 제외한 상태에서 맞은 번호의 개수 구함
        int highestResult = getHighestResult(lowestResult); // 맞은 번호의 개수에서 0의 개수를 더함

        return new int[]{checkMyRank(highestResult), checkMyRank(lowestResult)}; // 맞은 개수를 통하여 등수를 구해 배열로 반환
    }

    // 지워진 번호 0을 제외한 상태에서 일치하는 번호의 개수를 구하여 반환
    public int getLowestResult() {
        int result = 0;

        for(Map.Entry<Integer, Integer> entry : myMap.entrySet()) {
            int key = entry.getKey();

            if(!winMap.containsKey(key)) continue;
            result++;
        }

        return result;
    }

    // 0으로 표기된 번호가 모두 맞았다고 가정하여 맞은 개수를 반환
    public int getHighestResult(int value) {
        return value + myMap.getOrDefault(0, 0);
    }

    // 맞은 개수를 통하여 순위를 반환
    public int checkMyRank(int score) {
        if(score == 6) return 1;
        if(score == 5) return 2;
        if(score == 4) return 3;
        if(score == 3) return 4;
        if(score == 2) return 5;
        return 6;
    }

    public void initWinMap(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            int key = arr[i];
            winMap.put(key, winMap.getOrDefault(key, 0) + 1);
        }
    }

    public void initMyMap(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            int key = arr[i];
            myMap.put(key, myMap.getOrDefault(key, 0) + 1);
        }
    }
}