import java.io.*;
import java.util.*;

class Node {
    int r, c;
    public Node(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

public class Main {
	static int N,M; // N : 모수, R : 추출할 갯수
	static int totalmin;
	static boolean[] selected; //치킨집의 selected
	static List<Node> chicken;
	static List<Node> house;
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		
		house = new ArrayList<>();
        chicken = new ArrayList<>();
        totalmin=Integer.MAX_VALUE;
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int val = Integer.parseInt(st.nextToken());
                if (val == 1) {
                    house.add(new Node(i, j));
                } 
                else if (val == 2) {
                    chicken.add(new Node(i, j));
                }
            }
        }
        selected=new boolean[chicken.size()];
        combination(0,0);
        System.out.println(totalmin);
        
	} // main
	private static void combination(int idx, int count) {
	    if (count == M) {
	        int combinMin=0;
	        for (Node h : house) {
	            int minHouseDist = Integer.MAX_VALUE;
	            
	            for (int i = 0; i < chicken.size(); i++) {
	                if (selected[i]) {
	                    Node c = chicken.get(i);
	                    int dist = Math.abs(h.r - c.r) + Math.abs(h.c - c.c);
	                    minHouseDist = Math.min(minHouseDist, dist);
	                }
	            }
	            combinMin += minHouseDist;
	        }
	        totalmin = Math.min(totalmin, combinMin);
	        return;
	    }
	    
	    for (int i = idx; i < chicken.size(); i++) {
	        selected[i] = true; 
	        combination(i + 1, count + 1);
	        selected[i] = false; 
	    }
	}
} // class

