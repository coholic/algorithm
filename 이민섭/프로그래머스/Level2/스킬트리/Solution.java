package Level2.스킬트리;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int count = 0;

        for(String skillSet : skill_trees) {
            if(checkValidation(skill, skillSet)) count++;
        }

        return count;
    }

    public boolean checkValidation(String guide, String skill) {
        String sequence = skill.replaceAll("[^" + guide + "]", "");

        if(sequence.length() == guide.length()) return sequence.equals(guide);

        return guide.startsWith(sequence);
    }
}