import java.util.Arrays;
import java.util.Scanner;

/*
 * Permutation : 순열 : 서로 다른 n개의 원소 중에서 r개를 골라 순서를 고려하여 나열하는 경우의 수
 * nPr = n! / (n−r)!
 */
public class Main {

	static int N,R; // 순열 nPr : n개의 숫자 중 r개를 추출 (순서 있음)
	static int [] input; // 입력 값
	static int [] number; // 추출 값
	static boolean [] isSelected; // 추출 여부
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		R = scan.nextInt();
		input = new int[N];
		isSelected = new boolean[N];
		number = new int[R];

		for (int i = 0; i < N; i++) {
			input[i] = i+1;
		} // for - i

		permutation(0); // 0 : 시작 번지
		scan.close();
	} // main

	// idx : 순열의 자리 - 2자리 수인 경우 0번지,1번지 - input 배열의 숫자를 추출할 번지
	private static void permutation(int idx) {
		StringBuilder sb = new StringBuilder();
		if(idx >= R) {
			for (int i = 0; i < R; i++) {
				sb.append(number[i]).append(" ");
			}
			System.out.println(sb.toString());
			return;
		}

		for (int i = 0; i < N; i++) {
			if( isSelected[i] ) continue;
			
			if (idx>=1) {
				if (number[idx-1]>input[i]) {
					continue;
				}
			}
			
			number[idx] = input[i];
			
			isSelected[i] = true;

			permutation(idx + 1);

			isSelected[i] = false;
		} // for - i

	} // permutation

} // class
