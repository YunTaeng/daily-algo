import java.util.*;
import java.io.*;

class Solution {
    static boolean[] visited;
    static int minDepth = Integer.MAX_VALUE; // 최솟값을 찾아야 하니까!

    public int solution(String begin, String target, String[] words) {
        // 1. 초기화 필수!
        visited = new boolean[words.length];
        minDepth = Integer.MAX_VALUE;

        // 2. DFS 호출
        DFS(begin, target, words, 0);

        return (minDepth == Integer.MAX_VALUE) ? 0 : minDepth;
    }
    
    static void DFS(String cur,String target,String[] words, int depth) {
    	if(cur.equals(target)) {
    		minDepth = Math.min(minDepth, depth);
    		return;
    	}
    	for (int i = 0; i < words.length; i++) {
            if (!visited[i] && worddiff(cur, words[i])) {
                visited[i] = true;
                DFS(words[i], target, words, depth + 1);
                visited[i] = false; // 다른 경로 탐색을 위해 방문 해제(백트래킹)
            }
        }
    	
    	
    }
    
    static boolean worddiff(String a,String b) {
    	int difcnt=0;
    	for( int i= 0 ; i<a.length() ; i++) {
    		if(a.charAt(i)!=b.charAt(i)) difcnt++;
    	}
    	if(difcnt==1) return true;
    	return false;
    }
}