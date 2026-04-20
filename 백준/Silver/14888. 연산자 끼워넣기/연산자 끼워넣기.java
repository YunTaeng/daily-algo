import java.util.*;
import java.io.*;

public class Main {

	static int N;
	static int [] input; // 입력 값
	static int [] ops;
	static int maxAns;
	static int minAns;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());

		input = new int[N];
		ops = new int[4];
		
		maxAns = Integer.MIN_VALUE;
		minAns = Integer.MAX_VALUE;
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		} // for - i
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			ops[i] = Integer.parseInt(st.nextToken());
		} // for - i
		
		OperatorPlacement(1,input[0]);
		System.out.println(maxAns);
		System.out.println(minAns);
	} // main

	private static void OperatorPlacement(int idx,int currentResult) {

		if (idx == N) {
	        maxAns = Math.max(maxAns, currentResult);
	        minAns = Math.min(minAns, currentResult);
	        return;
	    }
		
		for (int j=0;j<4;j++) {
			if (ops[j]>0) {
				ops[j]-=1;
				int nextResult = currentResult;
				switch (j) {
                case 0: nextResult += input[idx]; break;
                case 1: nextResult -= input[idx]; break;
                case 2: nextResult *= input[idx]; break;
                case 3: nextResult /= input[idx]; break;
            }
				

				OperatorPlacement(idx + 1,nextResult);

				ops[j]+=1;	
				
			}
			
		}
		

	} // permutation

} // class
