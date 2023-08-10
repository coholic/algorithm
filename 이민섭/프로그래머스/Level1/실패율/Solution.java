package Level1.실패율;

import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
import java.lang.Comparable;

class Solution {

    public static Map<Integer, Integer> resultMap;
    public static StageInfo[] resultArr;

    public int[] solution(int N, int[] stages) {
        initResultMap(N);
        initResultArr(N);
        mkResultMap(stages);
        setFailure(stages.length);

        Arrays.sort(resultArr);

        return getResult();
    }

    public void mkResultMap(int[] stages) {
        for(int key : stages) {
            resultMap.put(key - 1, resultMap.get(key - 1) + 1);
        }
    }

    public void initResultMap(int N) {
        resultMap = new HashMap<>();

        for(int i = 0; i <= N; i++) {
            resultMap.put(i, 0);
        }
    }

    public void initResultArr(int N) {
        resultArr = new StageInfo[N];

        for(int i = 0; i < resultArr.length; i++) {
            resultArr[i] = new StageInfo(i);
        }
    }

    public void setFailure(int user) {
        for(Map.Entry<Integer, Integer> entry : resultMap.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();

            if(key == resultArr.length) continue;

            double failure = (user == 0)? 0 : (double)value/user;

            resultArr[key].setFailure(failure);

            user -= value;
        }
    }

    public int[] getResult() {
        int[] result = new int[resultArr.length];

        for(int i = 0; i < resultArr.length; i++) {
            result[i] = resultArr[i].getNumber();
        }

        return result;
    }

    public class StageInfo implements Comparable<StageInfo> {
        private int number;
        private double failure;

        public StageInfo(int number) {
            this.number = number + 1;
            this.failure = 0.0;
        }

        public int getNumber() {
            return this.number;
        }

        public double getFailure() {
            return this.failure;
        }

        public void setFailure(double failure) {
            this.failure = failure;
        }

        @Override
        public int compareTo(StageInfo v1) {
            if(this.getFailure() == v1.getFailure()) {
                return this.getNumber() - v1.getNumber();
            }
            return (-1) * Double.compare(this.getFailure(), v1.getFailure());
        }
    }
}