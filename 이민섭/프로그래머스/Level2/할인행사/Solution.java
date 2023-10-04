package Level2.할인행사;

import java.util.Map;
import java.util.HashMap;

class Solution {
    public static Map<String, Integer> wantMap = new HashMap<>();
    public static Map<String, Integer> productMap = new HashMap<>();

    public int solution(String[] want, int[] number, String[] discount) {
        int count = 0;
        mkWantMap(want, number);
        initProductMap(discount);

        for(int i = 0; i < discount.length - 10; i++) {
            if(checkValidation()) count++;

            String out = discount[i];
            String in = discount[i+10];

            editProductMap(out, in);
        }

        if(checkValidation()) count++;

        return count;
    }

    public void editProductMap(String out, String in) {
        productMap.put(out, productMap.get(out) - 1);

        if(productMap.get(out) == 0) productMap.remove(out);

        productMap.put(in, productMap.getOrDefault(in, 0) + 1);
    }

    public boolean checkValidation() {
        for(Map.Entry<String, Integer> entry : productMap.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();

            if(!wantMap.containsKey(key)) return false;
            if(wantMap.get(key) != value) return false;
        }

        return true;
    }

    public void initProductMap(String[] discount) {
        for(int i = 0; i < 10; i++) {
            String key = discount[i];

            productMap.put(key, productMap.getOrDefault(key, 0) + 1);
        }
    }

    public void mkWantMap(String[] want, int[] number) {
        for(int i = 0; i < number.length; i++) {
            wantMap.put(want[i], number[i]);
        }
    }
}
