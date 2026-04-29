import java.util.*;
import java.io.*;

class Solution {
    static boolean[] visited;
    static List<String> path=new ArrayList<>();

    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        Arrays.sort(tickets, (a, b) -> a[1].compareTo(b[1]));
        DFS("ICN","ICN",tickets,0);
        
        return path.get(0).split(" ");
    }
    
    static void DFS(String cur, String route,String[][] tickets,int cnt) {
    	if(cnt==tickets.length) {
    		path.add(route);
    		return;
    	}
    	for (int i = 0; i < tickets.length; i++) {
    		if(!visited[i] && tickets[i][0].equals(cur)) {
    			visited[i] = true;
                DFS(tickets[i][1],route + " " + tickets[i][1],tickets,cnt+1);
                visited[i] = false;
    		}
                
        }
    	
    	
    }
    
}