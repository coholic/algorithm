package level2;

public class 점프와순간이동 {
    public int solution(int n) {

        int ans = 1;

        while (n != 1) {

            if (n % 2 == 1) {

                ans++;
                n--;
            }

            n /= 2;
        }

        return ans;
    }
}
