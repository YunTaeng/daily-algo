import java.util.*;
import java.io.*;

public class Main {
	public static int [] input;
	public static int [] answer;
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    	StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(br.readLine());
        input=new int[N];
        answer=new int[N];
        
        for (int i = 0 ;i<N;i++) {
        	input[i]=Integer.parseInt(br.readLine());
        }
        int MAX_VAL = Arrays.stream(input).max().getAsInt();
        int[] count = new int[MAX_VAL + 1];
        for(int x : input) count[x]++;
        
        for(int i = 0; i < N; i++) {
            int val = input[i];
            int divisors = 0;
            for(int j = 1; j * j <= val; j++) {
                if(val % j == 0) {
                    divisors += count[j]; // 약수 j
                    if(j * j != val) divisors += count[val / j]; // 약수 val/j
                }
            }
            answer[i] = divisors - 1; // 자기 자신 제외
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0 ;i<N;i++) {
        	sb.append(answer[i]).append("\n");
        }
        System.out.println(sb.toString());
        br.close();
    } // main

} // class