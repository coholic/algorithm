package Level2.멀리뛰기;

class Solution {
    public static long[] resultArr;

    public long solution(int n) {
        initResultArr(n);
        mkResultArr();

        return resultArr[n];
    }

    public void mkResultArr() {
        resultArr[1] = 1;

        if(resultArr.length == 2) return;

        resultArr[2] = 2;

        for(int i = 3; i < resultArr.length; i++) {
            resultArr[i] = (resultArr[i-1] + resultArr[i-2]) % 1234567;
        }
    }

    public void initResultArr(int length) {
        resultArr = new long[length + 1];
    }
}
