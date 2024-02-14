package Level2.거리두기확인하기;

class Solution {
    public int[] solution(String[][] places) {
        int[] resultArr = new int[places.length];
        int index = 0;

        for(String[] place : places) {
            if(checkValidation(place)) {
                resultArr[index++] = 1;
                continue;
            }
            resultArr[index++] = 0;
        }

        return resultArr;
    }

    private boolean checkValidation(String[] arr) {
        String[][] resultArr = new String[5][5];

        for(int height = 0; height < 5; height++) {
            resultArr[height] = arr[height].split("");
        }

        for(int height = 0; height < 5; height++) {
            for(int width = 0; width < 5; width++) {
                if(!resultArr[height][width].equals("P")) continue;

                if(!checkNorthValidation(width, height, resultArr)) return false;
                if(!checkEastValidation(width, height, resultArr)) return false;
                if(!checkSouthValidation(width, height, resultArr)) return false;
                if(!checkWestValidation(width, height, resultArr)) return false;
            }
        }

        return true;
    }

    private boolean checkNorthValidation(int x, int y, String[][] resultArr) {
        if(y >= 1 && resultArr[y-1][x].equals("P")) return false;
        if(y >= 1 && resultArr[y-1][x].equals("X")) return true;
        if(y >= 1 && x >= 1 && resultArr[y-1][x-1].equals("P")) return false;
        if(y >= 1 && x < 4 && resultArr[y-1][x+1].equals("P")) return false;
        if(y >= 2 && resultArr[y-2][x].equals("P")) return false;

        return true;
    }

    private boolean checkEastValidation(int x, int y, String[][] resultArr) {
        if(x < 4 && resultArr[y][x+1].equals("P")) return false;
        if(x < 4 && resultArr[y][x+1].equals("X")) return true;
        if(x < 4 && y >= 1 && resultArr[y-1][x+1].equals("P")) return false;
        if(x < 4 && y < 4 && resultArr[y+1][x+1].equals("P")) return false;
        if(x < 3 && resultArr[y][x+2].equals("P")) return false;

        return true;
    }

    private boolean checkSouthValidation(int x, int y, String[][] resultArr) {
        if(y < 4 && resultArr[y+1][x].equals("P")) return false;
        if(y < 4 && resultArr[y+1][x].equals("X")) return true;
        if(y < 4 && x >= 1 && resultArr[y+1][x-1].equals("P")) return false;
        if(y < 4 && x < 4 && resultArr[y+1][x+1].equals("P")) return false;
        if(y < 3 && resultArr[y+2][x].equals("P")) return false;

        return true;
    }

    private boolean checkWestValidation(int x, int y, String[][] resultArr) {
        if(x >= 1 && resultArr[y][x-1].equals("P")) return false;
        if(x >= 1 && resultArr[y][x-1].equals("X")) return true;
        if(x >= 1 && y >= 1 && resultArr[y-1][x-1].equals("P")) return false;
        if(x >= 1 && y < 4 && resultArr[y+1][x-1].equals("P")) return false;
        if(x >= 2 && resultArr[y][x-1].equals("P")) return false;

        return true;
    }
}
