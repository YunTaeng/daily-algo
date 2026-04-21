import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int N;
	static int [] input; 
	static int [] number;
	static boolean [] isSelected;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = 9;
	
		input = new int[N]; // {1,2,3,4,5}
		isSelected = new boolean[N]; // 추출 여부 - 중복된 수 추출 방지
		number = new int[7]; // 추출된 수를 저장

		for (int i = 0; i < N; i++) {
			input[i] = scan.nextInt();
		} // for - i

		permutation(0); // 0 : 시작 번지

		scan.close();
	} // main

	// idx : 순열의 자리 - 2자리 수인 경우 0번지,1번지 - input 배열의 숫자를 추출할 번지
	private static void permutation(int idx) {

		if(idx >= 7) {
			if( Arrays.stream(number).sum()==100) {
				for(int i=0;i<7;i++) {
					System.out.println(number[i]);
				}
				System.exit(0);
			}
			return;
		}

		for (int i = 0; i < N; i++) {
			if( isSelected[i] ) continue;

			number[idx] = input[i];
			isSelected[i] = true;

			permutation(idx + 1);

			isSelected[i] = false;
		} // for - i

	} // permutation
}//classPermutationTest