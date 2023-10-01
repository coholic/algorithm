package Level2.다리를지나는트럭;

import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public static Queue<Integer> resultQueue = new LinkedList<>();
    public static int truckCount = 0;
    public static int weightSum = 0;
    public static int truckIndex = 0;
    public static int time = 1;

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        while(truckCount != truck_weights.length) {
            moveToBridge(weight, truck_weights);
            if(resultQueue.size() == bridge_length) moveToLand();
            time++;
        }

        return time;
    }

    public void moveToLand() {
        int truck = resultQueue.poll();
        weightSum -= truck;

        if(truck != 0) truckCount++;
    }

    public void moveToBridge(int limit, int[] trucks) {
        if(truckIndex == trucks.length) {
            resultQueue.offer(0);
            return;
        }

        int truck = trucks[truckIndex];

        if(truck + weightSum <= limit) {
            resultQueue.offer(truck);
            truckIndex++;
            weightSum += truck;
            return;
        }

        resultQueue.offer(0);
    }
}
