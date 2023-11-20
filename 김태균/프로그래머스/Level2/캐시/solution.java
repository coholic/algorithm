import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        LinkedList<String> caches = new LinkedList();
        int count =0;
        for (int i = 0;i < cities.length;i++){
            cities[i] = cities[i].toLowerCase();
            if (cacheSize == 0){
                return cities.length*5;
            }
            if (caches.contains(cities[i])){
                caches.remove(cities[i]);
                caches.add(cities[i]);
                count += 1;
            } else {
                if (caches.size() == cacheSize){
                    caches.remove(0);
                }
                caches.add(cities[i]);
                count+=5;
            }
        }
        return count;
    }
}