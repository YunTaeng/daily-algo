import java.util.*;
import java.io.*;

public class Main {

	static int N;
	static long [][] input;
	static boolean [] isSelected;
	static long minDiff;

	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
		
        
		N = Integer.parseInt(st.nextToken());
		
		
		input = new long[N][2];
		isSelected = new boolean[N];
		minDiff=Integer.MAX_VALUE;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			input[i][0] = Integer.parseInt(st.nextToken());
			input[i][1] = Integer.parseInt(st.nextToken());
		}
		
		subset(0);
		
		System.out.println(minDiff);
		br.close();
	} // main

	private static void subset(int idx) {

		if(idx >= N) {
			long sour=1;
			long bitter=0;
			boolean leastOne = false;
			for (int i = 0; i < N; i++) {
				if(isSelected[i]) {
					sour*=input[i][0];
					bitter+=input[i][1];
					leastOne = true;
				}
			}
			if (leastOne) {
				long diff = Math.abs(sour - bitter);
				if (diff<minDiff) minDiff = diff;
			}
			return;
		}

		//부분 집합에 현재 원소를 넣어서 실행
		isSelected[idx] = true;
		subset(idx + 1);

		//부분 집합에 현재 원소를 빼고 실행
		isSelected[idx] = false;
		subset(idx + 1);

	} // subset

} // class

