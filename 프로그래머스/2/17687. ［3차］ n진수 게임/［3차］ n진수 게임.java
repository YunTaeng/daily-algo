import java.util.*;
class Solution {
    public String solution(int n, int t, int m, int p) {
        Queue<Character> que = new LinkedList<>();
        StringBuilder answer = new StringBuilder();
        
        int num = 0;
        
        while (answer.length() < t) {
            
            String tBaseString = Integer.toString(num++, n).toUpperCase();
            
            for (int j = 0; j < tBaseString.length(); j++) {
                que.add(tBaseString.charAt(j));
            }
            
            while (que.size() >= m) {
                char[] turnChars = new char[m];
                for (int k = 0; k < m; k++) {
                    turnChars[k] = que.poll();
                }
                answer.append(turnChars[p - 1]);
                if (answer.length() == t) break;
            }
        }
        
        return answer.toString();
    }
}