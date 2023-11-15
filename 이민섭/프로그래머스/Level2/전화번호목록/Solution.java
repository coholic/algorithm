package Level2.전화번호목록;

import java.util.Arrays;

class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);

        for(int i = 0; i < phone_book.length-1; i++) {
            String prefix = phone_book[i];
            String value = phone_book[i+1];

            if(!value.contains(prefix)) continue;
            if(checkValidation(prefix, value)) return false;
        }

        return true;
    }

    public boolean checkValidation(String prefix, String value) {
        return value.startsWith(prefix);
    }
}
