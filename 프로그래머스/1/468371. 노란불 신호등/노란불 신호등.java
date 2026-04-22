class Solution {
    public int solution(int[][] signals) {
        int answer = 0;
        
        while (answer<5000000){
            answer+=1;
            boolean all_yellow = true;
            for (int i=0;i<signals.length;i++){
                int G=signals[i][0];
                int Y=signals[i][1];
                int R=signals[i][2];
                int tmp=answer%(G+Y+R);
                if (G >= tmp || tmp> G + Y){
                    all_yellow = false;
                    break;
                }
                
            }
                
            if (all_yellow){
                return answer;
            }
            
            
        }
        
    
        return -1;
    }
}