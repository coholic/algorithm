package level2;

public class 괄호회전하기 {
    public int solution(String s) {

        int answer = 0;

        for (int x = 0; x < s.length(); x++) {

            String str = "";

            for (int i = x; i < s.length(); i++) {
                str = str + s.charAt(i) + "";
            }

            for (int i = 0; i < x; i++) {
                str = str + s.charAt(i) + "";
            }

            while (!str.equals("")) {

                boolean flag = false;

                if (str.contains("[]")) {
                    str = str.replaceAll("\\[\\]", "");
                    flag = true;
                }

                if (str.contains("{}")) {
                    str = str.replaceAll("\\{\\}", "");
                    flag = true;
                }

                if (str.contains("()")) {
                    str = str.replaceAll("\\(\\)", "");
                    flag = true;
                }

                if (!flag)
                    break;
            }

            if (str.equals(""))
                answer++;
        }

        return answer;
    }
}