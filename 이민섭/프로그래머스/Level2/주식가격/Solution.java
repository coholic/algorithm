package Level2.주식가격;

class Solution {
    public int[] solution(int[] prices) {
        return getResultArr(prices);
    }

    public int[] getResultArr(int[] prices) {
        int[] resultArr = new int[prices.length];

        for(int i = 0; i < resultArr.length; i++) {
            for(int j = i+1; j < resultArr.length; j++) {
                if(i != resultArr.length-1) resultArr[i]++;
                if(prices[i] > prices[j]) break;
            }
        }

        return resultArr;
    }
}