import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        StringBuilder sb = new StringBuilder();
        
        for ( int i=9;i>=0;i--) {
            char digitChar = (char) (i + '0');
        	long countX = X.chars().filter(ch -> ch == digitChar).count();
            long countY = Y.chars().filter(ch -> ch == digitChar).count();
        	long minCount = Math.min(countX, countY);
        	for ( int j=0;j<minCount;j++) {
        		sb.append(i);
        	}
        }
        String answer = sb.toString();
        if (answer.isEmpty()) return "-1";
        if (answer.charAt(0) == '0') return "0";
        
        return answer;
    }
}