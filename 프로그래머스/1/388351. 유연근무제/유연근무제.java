class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        int N = schedules.length;
        for (int i=0;i<N;i++){
            int scheduleTime = schedules[i]/100*60+schedules[i]%100;
            boolean late = false;
            for(int j=0;j<7 ;j++){
                int currentDay = (startday + j - 1) % 7 + 1;
                if (currentDay == 6 || currentDay == 7) continue;
                int timelogTime = timelogs[i][j]/100*60+timelogs[i][j]%100;
                if (timelogTime > scheduleTime + 10){
                    late = true;
                    break;
                }
                
            }
            if(!late) answer++;
            
        }
        
        
        
        
        return answer;
    }
}