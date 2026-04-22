import java.io.*;
import java.util.*;
public class Main {
	static int N; // N크기 , M 남길 치킨집, C 전체 치킨집
	static int input[][];
	static int totalMax;
	static boolean[] selected; //치킨집의 selected
	
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
		
        N = Integer.parseInt(st.nextToken());
        input=new int[N][2];
		selected=new boolean[N];
        totalMax=Integer.MIN_VALUE;
        
		for (int i =0; i< N ; i++) {
			st = new StringTokenizer(br.readLine());
			input[i][0]=Integer.parseInt(st.nextToken());
			input[i][1]=Integer.parseInt(st.nextToken());
		}
		
		
        
        
        combination(0);
        System.out.println(totalMax);
        
	} // main
	private static void combination(int idx) {
		if(idx>=N) {
			int income=0;
			for (int i = 0; i < N; i++) {
				if(selected[i]) {
					income+=input[i][1];
				}
			}
			totalMax=Math.max(totalMax, income);
			return;
		}
		
		selected[idx]=true;
		if(idx+input[idx][0]<=N) {
			combination(idx+input[idx][0]);
		}
		
		selected[idx]=false;
		combination(idx+1);
	}
	

} // class

