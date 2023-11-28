package Level2.카펫;

class Solution {
    public int[] solution(int brown, int yellow) {
        int height = 0;
        int width = 0;

        for(int i = 1; i <= brown; i++) {
            width = i + 2;
            height = ((brown + 4)/2) - width;

            if(height <= 0) continue;
            if(height > width) continue;
            if(!checkBrownValidation(height, width, brown)) continue;
            if(!checkYellowValidation(height, width, yellow)) continue;

            return new int[]{width, height};
        }

        return new int[]{};
    }

    private boolean checkBrownValidation(int height, int width, int brown) {
        return ((2 * height) + (2 * width) - 4) == brown;
    }

    private boolean checkYellowValidation(int height, int width, int yellow) {
        return ((height - 2) * (width - 2)) == yellow;
    }
}
