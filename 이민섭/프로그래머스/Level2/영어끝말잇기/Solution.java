package Level2.영어끝말잇기;

import java.util.Set;
import java.util.HashSet;

class Solution {
    public static Set<String> wordSet = new HashSet<>();

    public int[] solution(int n, String[] words) {
        return getLoserInfo(n, words);
    }

    public int[] getLoserInfo(int n, String[] words) {
        int person = 1;
        int turn = 1;
        String lastWord = "" + words[0].charAt(0);

        for(int i = 0; i < words.length; i++) {
            String word = words[i];

            if(lastWord.charAt(lastWord.length()-1) != word.charAt(0)) return new int[]{person, turn};
            if(wordSet.contains(word)) return new int[]{person, turn};
            wordSet.add(word);
            lastWord = word;
            person = (i+1) % n + 1;
            turn = (i+1)/n + 1;
        }

        return new int[]{0, 0};
    }
}
