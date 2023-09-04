package Level1.개인정보수집유효기간;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.LinkedList;

class Solution {
    public static Map<String, Integer> contractMap = new HashMap<>();

    public int[] solution(String today, String[] terms, String[] privacies) {
        mkContractMap(terms);

        return getDisposeData(today, privacies);
    }

    public int[] getDisposeData(String today, String[] privacies) {
        List<Integer> resultList = new LinkedList<>();
        int[] todayArr = getDateArr(today);

        for(int i = 0; i < privacies.length; i++) {
            if(!checkValidation(todayArr, privacies[i])) resultList.add(i+1);
        }

        return resultList.stream().mapToInt(Integer::intValue).toArray();
    }

    public boolean checkValidation(int[] today, String privacy) {
        int[] expirationArr = getExpirationArr(privacy);

        if(today[0] < expirationArr[0]) return true;
        if(today[0] > expirationArr[0]) return false;
        if(today[1] < expirationArr[1]) return true;
        if(today[1] > expirationArr[1]) return false;
        if(today[2] > expirationArr[2]) return false;

        return true;
    }

    public int[] getDateArr(String date) {
        int[] resultArr = new int[3];
        String[] dateArr = date.split("[.]");

        for(int i = 0; i < 3; i++) {
            resultArr[i] = Integer.parseInt(dateArr[i]);
        }

        return resultArr;
    }

    public int[] getExpirationArr(String privacy) {
        String[] arr = privacy.split(" ");

        int[] dateArr = getDateArr(arr[0]);
        int duration = contractMap.get(arr[1]);

        dateArr[1] += duration;

        while(dateArr[1] >= 13) {
            dateArr[1] -= 12;
            dateArr[0]++;
        }

        if(dateArr[2] == 1 && dateArr[1] == 1) {
            dateArr[0]--;
            dateArr[1] = 12;
            dateArr[2] = 28;
            return dateArr;
        }

        if(dateArr[2] == 1) {
            dateArr[1]--;
            dateArr[2] = 28;
            return dateArr;
        }

        dateArr[2]--;
        return dateArr;
    }

    public void mkContractMap(String[] terms) {
        for(String term : terms) {
            String[] arr = term.split(" ");

            contractMap.put(arr[0], Integer.parseInt(arr[1]));
        }
    }
}
