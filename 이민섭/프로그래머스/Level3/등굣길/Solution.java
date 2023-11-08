package Level3.등굣길;

class Solution {
    private int[][] resultArr;

    public int solution(int m, int n, int[][] puddles) {
        initResultArr(n, m, puddles);
        mkPuddle(puddles);
        mkResultArr();

        return resultArr[n-1][m-1];
    }

    public void initResultArr(int height, int width, int[][] puddle) {
        resultArr = new int[height][width];

        for(int i = 0; i < height; i++) {
            resultArr[i][0] = 1;
        }

        for(int i = 0; i < width; i++) {
            resultArr[0][i] = 1;
        }
    }

    public void mkPuddle(int[][] puddle) {
        for(int[] arr : puddle) {
            int width = arr[0];
            int height = arr[1];

            resultArr[height-1][width-1] = -1;
        }

        boolean flag = false;

        for(int i = 0; i < resultArr.length; i++) {
            int value = resultArr[i][0];

            if(value == -1) {
                flag = true;
            }

            if(flag) {
                resultArr[i][0] = 0;
                continue;
            }
        }

        flag = false;

        for(int i = 0; i < resultArr[0].length; i++) {
            int value = resultArr[0][i];

            if(value == -1) {
                flag = true;
            }

            if(flag) {
                resultArr[0][i] = 0;
                continue;
            }
        }
    }

    public void mkResultArr() {
        for(int i = 1; i < resultArr.length; i++) {
            for(int j = 1; j < resultArr[i].length; j++) {
                int value = resultArr[i][j];

                if(value == -1) {
                    resultArr[i][j] = 0;
                    continue;
                }

                resultArr[i][j] = (resultArr[i-1][j] + resultArr[i][j-1]) % 1_000_000_007;
            }
        }
    }
}