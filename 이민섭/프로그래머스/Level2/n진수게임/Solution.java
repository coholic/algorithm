package Level2.n진수게임;

class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();

        String initialString = getInitialString(n, t, m);
        char[] resultArr = initialString.toCharArray();

        int count = 0;

        for(int i = 0; i < resultArr.length; i++) {
            if(count == t) break;
            if((i % m) == (p-1)) {
                sb.append(resultArr[i]);
                count++;
            }
        }

        return sb.toString();
    }

    private String getInitialString(int n, int t, int m) {
        StringBuilder sb = new StringBuilder();
        int value = 0;

        while(sb.length() < t * m) {
            String convertedString = Integer.toString(value, n);
            sb.append(convertedString.toUpperCase());
            value++;
        }

        return sb.toString();
    }
}