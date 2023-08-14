package Level1;

import java.util.Queue;
import java.util.LinkedList;

public class 카드뭉치 {
    public String solution(String[] cards1, String[] cards2, String[] goal) {

        Queue<String> queue = new LinkedList<>();
        int check1 = 0;
        int check2 = 0;

        for(String word : goal) {
            queue.offer(word);
        }

        while(!queue.isEmpty()) {

            String word = queue.peek();

            if(word.equals(cards1[check1])) {

                if(check1 == cards1.length - 1)
                    queue.poll();
                else {
                    queue.poll();
                    check1++;
                }
            } else if(word.equals(cards2[check2])) {

                if(check2 == cards2.length - 1)
                    queue.poll();
                else {
                    queue.poll();
                    check2++;
                }
            } else
                return "No";
        }

        return "Yes";
    }
}
