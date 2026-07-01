import java.util.*;

class Solution {
    public int solution(int[] food_times, long k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        long totalTime = 0; // 먹는데 사용한 총 시간
        long previousTime = 0; // 직전에 다 먹은 음식의 시간
        long remainingFoods = food_times.length; // 남은 음식의 개수
        for (int i = 0; i < remainingFoods; i++) {
            pq.add(new int[]{food_times[i], i + 1});
        }
        while(!pq.isEmpty()){
            int[] current = pq.peek();
            long currentTime = current[0];
            
            long spendTime = (currentTime - previousTime) * remainingFoods;
            
            if (k >= spendTime) {
                k -= spendTime;
                previousTime = currentTime;
                pq.poll();
                remainingFoods--;
            } else {
                List<int[]> remainingList = new ArrayList<>(pq);
                remainingList.sort((a, b) -> Integer.compare(a[1], b[1]));
                return remainingList.get((int)(k % remainingFoods))[1]; 
            }
        }
        
        return -1;
    }
}