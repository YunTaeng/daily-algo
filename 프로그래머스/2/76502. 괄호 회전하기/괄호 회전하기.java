import java.io.*;
import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        for(int i =0;i<s.length();i++) {
        	String rotated = s.substring(i) + s.substring(0, i);
        	if (ABC(rotated)) {
                answer++;
            }
        }
        
        return answer;
    }
	private boolean ABC(String s) {
		Stack<Character> st = new Stack<>();
		for(int i=0 ; i<s.length();i++) {
			char c = s.charAt(i);
			if (c == '[' || c == '{' || c == '(') {
                st.push(c);
            }
			else {
                // 스택이 비어있으면 짝을 맞출 열린 괄호가 없는 것이므로 실패
                if (st.isEmpty()) return false;
                
                char top = st.pop();
                // 짝이 맞지 않는 경우 실패
                if (c == ']' && top != '[') return false;
                if (c == '}' && top != '{') return false;
                if (c == ')' && top != '(') return false;
            }
		}
		return st.isEmpty();
	}
    
    
    
}