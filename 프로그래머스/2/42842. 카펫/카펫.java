class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        
        for(int i =1;i<brown;i++) {
        	for(int j=1;j<=i;j++) {
        		if(i*j==yellow &&2*i+2*j+4 == brown) {
        			return new int[] {i+2,j+2};
        		}
        	}
        }
        
        return answer;
    }
    
}