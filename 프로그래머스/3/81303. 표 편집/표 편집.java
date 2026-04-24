import java.util.*;
import java.io.*;
class Solution {
    public String solution(int n, int k, String[] cmd) {
    	Stack <Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        boolean[] deleted=new boolean[n];
        int curr=k;
        int num;
        
        int[] prev = new int[n];
        int[] next = new int[n];
        for(int i = 0; i < n; i++) {
            prev[i] = i - 1;
            next[i] = i + 1;
        }
        next[n - 1] = -1;
        

        
        for (String s : cmd) {        	
        	StringTokenizer st =new StringTokenizer(s);
        	String oper = st.nextToken();
        	
        	switch(oper) {
        	case "U":{
        		num = Integer.parseInt(st.nextToken());
        		for (int i = 0; i < num; i++) curr = prev[curr];
        		break;
        	}case "D":{
        		num = Integer.parseInt(st.nextToken());
        		for (int i = 0; i < num; i++) curr = next[curr];
        		break;
        	}case "C":{
        		deleted[curr]=true;
        		stack.push(curr);
        		int p = prev[curr];
                int nxt = next[curr];
                
                // 연결 끊기
                if (p != -1) next[p] = nxt;
                if (nxt != -1) prev[nxt] = p;
                
                // 커서 이동
                if (nxt != -1) curr = nxt;
                else curr = p;
        		break;
        	}case "Z":{
        		int restore = stack.pop();
                deleted[restore] = false;
                int pp = prev[restore];
                int nn = next[restore];
                
                // 연결 복구
                if (pp != -1) next[pp] = restore;
                if (nn != -1) prev[nn] = restore;
                break;
        	}
        	
        	}//switch
        	
        	
        }//for cmd 실행
        
        for (int i =0;i<n;i++) {
        	sb.append(deleted[i] ? "X" : "O");
        }
        
        return sb.toString();
    }
}