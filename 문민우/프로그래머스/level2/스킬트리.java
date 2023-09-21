package level2;

import java.util.Queue;
import java.util.LinkedList;

public class 스킬트리 {
    public int solution(String skill, String[] skill_trees) {

        int answer = 0;

        Queue<String> queue = new LinkedList<>();

        for (String skillTree : skill_trees) {

            for (int i = 0; i < skill.length(); i++) {
                queue.offer(Character.toString(skill.charAt(i)));
            }

            boolean flag = true;

            for (int i = 0; i < skillTree.length(); i++) {

                String cur = Character.toString(skillTree.charAt(i));

                if (skill.contains(cur)) {

                    if (queue.peek().equals(cur))
                        queue.poll();

                    else {

                        flag = false;
                        break;
                    }
                }
            }

            if (flag)
                answer++;

            queue.clear();
        }

        return answer;
    }
}
