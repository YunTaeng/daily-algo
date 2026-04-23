import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int [][] input;
	static boolean[] selected;
	static int minDiff;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        N=Integer.parseInt(st.nextToken());
        selected = new boolean[N];
        input = new int [N][N];

        
        for (int i=0;i<N;i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j=0;j<N;j++) {
        		input[i][j]=Integer.parseInt(st.nextToken());
        	}
        }
        minDiff = Integer.MAX_VALUE;
        
        combin(0,0);
        System.out.println(minDiff);
        
    }//main
    
    private static void combin (int idx,int count) {
    	if(count>=N/2) {
    		calcDiff();
    		return;
    	}//if (idx>=N/2) 종료조건
    	
    	for (int i = idx; i < N; i++) {
            if (!selected[i]) {
                selected[i] = true;
                combin(i + 1, count + 1);
                selected[i] = false;
            }
        }
    }
    
    private static void calcDiff() {
    	int asum=0;
    	int bsum=0;
    	List<Integer> teamA = new ArrayList<>();
    	List<Integer> teamB = new ArrayList<>();
    	for(int i=0;i<N;i++) {
    		if (selected[i]) {
    			teamA.add(i);
    		}
    		else {
    			teamB.add(i);
    		}
    	}
    	
    	for(int i :teamA) {
    		for(int j :teamA) {
        		asum+=input[i][j];
        	}
    	}
    	for(int i :teamB) {
    		for(int j :teamB) {
        		bsum+=input[i][j];
        	}
    	}
    	minDiff=Math.min(Math.abs(asum-bsum),minDiff);
    }
}//Main