package Level1.카드뭉치;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        return getResult(cards1, cards2, goal);
    }

    public String getResult(String[] cards1, String[] cards2, String[] goal) {
        if(checkValidation(cards1, cards2, goal)) return "Yes";
        return "No";
    }

    public boolean checkValidation(String[] cards1, String[] cards2, String[] goal) {
        int card1Index = 0, card2Index = 0;

        for(int i = 0; i < goal.length; i++) {
            String word = goal[i];

            if(card1Index < cards1.length && word.equals(cards1[card1Index])) {
                card1Index++;
                continue;
            }

            if(card2Index < cards2.length && word.equals(cards2[card2Index])) {
                card2Index++;
                continue;
            }

            return false;
        }

        return true;
    }
}
