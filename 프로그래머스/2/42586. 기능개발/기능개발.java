import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        
        for (int i = 0; i < progresses.length; i++) {
            int remainingProgress = 100 - progresses[i];
            int days = (remainingProgress + speeds[i] - 1) / speeds[i];
            queue.offer(days);
        }
        
        List<Integer> answerList = new ArrayList<>();
        
        while (!queue.isEmpty()) {
            int currentDeployDay = queue.poll();
            int count = 1; 
            
            while (!queue.isEmpty() && queue.peek() <= currentDeployDay) {
                queue.poll();
                count++;
            }
            
            answerList.add(count);
        }
        
        return answerList.stream().mapToInt(i -> i).toArray();
    }
}