package Level1.신고결과받기;

import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

class Solution {
    public static Map<String, Integer> statusMap = new HashMap<>();
    public static Map<String, Set<String>> reportMap = new HashMap<>();

    public int[] solution(String[] id_list, String[] reports, int k) {
        for(String report : reports) {
            mkUserMap(report);
        }

        return getResultArr(id_list, k);
    }

    public int[] getResultArr(String[] user, int k) {
        int[] resultArr = new int[user.length];

        for(int i = 0; i < resultArr.length; i++) {
            resultArr[i] = getReportedUser(user[i], k);
        }

        return resultArr;
    }

    public int getReportedUser(String user, int k) {
        int count = 0;

        if(!reportMap.containsKey(user)) return 0;

        for(String member : reportMap.get(user)) {
            if(statusMap.get(member) >= k) count++;
        }

        return count;
    }

    public void mkUserMap(String report) {
        String[] status = report.split(" ");
        String from = status[0];
        String to = status[1];

        Set<String> valueSet = reportMap.getOrDefault(from, new HashSet<>());
        if(!valueSet.contains(to)) {
            statusMap.put(to, statusMap.getOrDefault(to, 0) + 1);
            valueSet.add(to);
        }

        reportMap.put(from, valueSet);
    }
}