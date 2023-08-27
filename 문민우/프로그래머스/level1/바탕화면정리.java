package level1;

public class 바탕화면정리 {
    public int[] solution(String[] wallpaper) {

        int lux = Integer.MAX_VALUE;
        int luy = Integer.MAX_VALUE;
        int rdx = Integer.MIN_VALUE;
        int rdy = Integer.MIN_VALUE;

        for(int i = 0; i < wallpaper.length; i++) {
            for(int j = 0; j < wallpaper[i].length(); j++) {

                if(wallpaper[i].charAt(j) == '#') {  // x, y 최소, 최대 탐색

                    lux = Math.min(lux, i);
                    luy = Math.min(luy, j);
                    rdx = Math.max(rdx, i);
                    rdy = Math.max(rdy, j);
                }
            }
        }

        return new int[] {lux, luy, rdx + 1, rdy + 1};  // rdx, rdy 는 끝점으로 +1
    }
}
