import java.util.*;
import java.io.*;

public class Main {
	static int N,R;
	static int [] input; // 입력 값
	static int [] number; // 추출 값
	static boolean [] isSelected; // 추출 여부
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		input = new int[N];
		isSelected = new boolean[N];
		number = new int[R];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		} // for - i

		Arrays.sort(input);
		permutation(0); // 0 : 시작 번지
		System.out.print(sb);
	} // main

	private static void permutation(int idx) {

		if(idx >= R) {
			for (int i = 0; i < R; i++) {
                sb.append(number[i]).append(" ");
            }
            sb.append("\n");
			return;
		}
		int used = 0;
		for (int i = 0; i < N; i++) {
			if (!isSelected[i] && used != input[i]) {
	            
				isSelected[i] = true;
	            
				used = input[i];
	            number[idx] = input[i];
	            
				permutation(idx + 1);

				isSelected[i] = false;
			}
			
			
		} // for - i

	} // permutation

} // class
