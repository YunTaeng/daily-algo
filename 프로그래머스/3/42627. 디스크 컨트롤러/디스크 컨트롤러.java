import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        int now=0;
        int completeCount=0;
        int jobIdx=0;
        int totalResponseTime=0;
        while(completeCount < jobs.length ){
            while (jobIdx < jobs.length && jobs[jobIdx][0] <= now) {
                pq.offer(jobs[jobIdx++]);
            }
            if (pq.isEmpty()){
                now=jobs[jobIdx][0];
            }
            else{
                int[] job = pq.poll();
                now += job[1];
                totalResponseTime += (now - job[0]);
                completeCount++;
            }
        }
        
        
        
        return totalResponseTime / jobs.length;
    }
}