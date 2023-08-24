package Level1.바탕화면정리;

class Solution {
    public static String[][] resultArr;
    public static int leftX = Integer.MAX_VALUE;
    public static int leftY = Integer.MAX_VALUE;
    public static int rightX = Integer.MIN_VALUE;
    public static int rightY = Integer.MIN_VALUE;

    public int[] solution(String[] wallpaper) {
        initResultArr(wallpaper);
        mkStandardPoint();

        return new int[]{leftY, leftX, rightY, rightX};
    }

    public void mkStandardPoint() {
        for(int i = 0; i < resultArr.length; i++) {
            for(int j = 0; j < resultArr[i].length; j++) {
                String value = resultArr[i][j];

                if(!value.equals("#")) continue;

                int lx = j;
                int ly = i;
                int rx = j+1;
                int ry = i+1;

                leftX = Math.min(leftX, lx);
                leftY = Math.min(leftY, ly);
                rightX = Math.max(rightX, rx);
                rightY = Math.max(rightY, ry);
            }
        }
    }

    public void initResultArr(String[] wallpaper) {
        int width = wallpaper[0].length();
        int height = wallpaper.length;

        resultArr = new String[height][width];

        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                resultArr[i][j] = wallpaper[i].charAt(j) + "";
            }
        }
    }
}