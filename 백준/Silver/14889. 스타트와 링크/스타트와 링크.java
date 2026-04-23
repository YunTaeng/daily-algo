import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int [][] input;
	static boolean[] selected;
	static int minDiff =Integer.MAX_VALUE;
	
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
        
        combin(0,0);
        System.out.println(minDiff);
        
    }//main
    
    private static void combin (int idx,int count) {
    	if(count>=N/2) {
    		int asum=0;
        	int bsum=0;
        	for(int i = 0; i < N; i++){
    			for(int j = i + 1; j < N; j++){ // j = i + 1 -> 중복 피하기

    				if( selected[i] &&  selected[j] ) asum += input[i][j] + input[j][i];

    				if( !selected[i] && !selected[j] ) bsum += input[i][j] + input[j][i];

    			} // for - j
    		} // for - i
        	minDiff=Math.min(Math.abs(asum-bsum),minDiff);
    		return;
    	}//if (idx>=N/2) 종료조건
    	
    	for (int i = idx; i < N; i++) {
            if (!selected[i]) {
                selected[i] = true;
                combin(i + 1, count + 1);
                selected[i] = false;
            }
        }
    	
    }//combin
}//Main