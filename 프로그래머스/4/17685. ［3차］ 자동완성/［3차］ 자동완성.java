import java.util.*;
class Solution {
    public int solution(String[] words) {
        int answer = 0;
        
        Arrays.sort(words);
        int N = words.length;
        for (int i = 0; i < N; i++) {
            int maxCommon = 0;
            
            if (i > 0) {
                maxCommon = Math.max(maxCommon, getCommonLength(words[i], words[i - 1]));
            }
            if (i < N - 1) {
                maxCommon = Math.max(maxCommon, getCommonLength(words[i], words[i + 1]));
            }
            
            answer += Math.min(words[i].length(), maxCommon + 1);
        }
        
        
        return answer;
    }
    private int getCommonLength(String s1, String s2) {
        int len = Math.min(s1.length(), s2.length());
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (s1.charAt(i) == s2.charAt(i)) count++;
            else break;
        }
        return count;
    }
}