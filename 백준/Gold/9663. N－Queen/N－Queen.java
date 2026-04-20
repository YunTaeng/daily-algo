import java.util.*;
import java.io.*;

public class Main {

	static int N;
	static int cnt;
	static int[] queens;
 	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		cnt=0;
		queens=new int[N];
		QueenPlacement(0);
		System.out.println(cnt);
	} // main

	private static void QueenPlacement(int rows) {

		if (rows == N) {
	        cnt+=1;
	        return;
	    }
		for (int i=0;i<N;i++) {
			if (isPossible(rows,i)){
				queens[rows] = i;
		        QueenPlacement(rows + 1);
			}
		}//for_i
	} // QueenPlacement
	private static boolean isPossible(int rows, int i) {
	    for (int x = 0; x < rows; x++) {
	        int y = queens[x];
	        if (y == i || Math.abs(x - rows) == Math.abs(y - i)) {
	            return false;
	        }
	    }
	    return true;
	}
} // class
