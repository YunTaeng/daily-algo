import java.util.*;
import java.io.*;

public class Main {
	
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//      StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        Long[] input=new Long[N];
        
        for ( int i =0; i<N ; i++) {
        	input[i]=Long.parseLong(br.readLine());
        }
        
        Arrays.sort(input); // 정렬하면 같은 숫자끼리 뭉쳐있음
        long maxNum = input[0];
        int maxCount = 1;
        int currentCount = 1;

        for (int i = 1; i < N; i++) {
            if (input[i].equals(input[i-1])) currentCount++;
            else currentCount = 1;
            
            if (currentCount > maxCount) {
                maxCount = currentCount;
                maxNum = input[i];
            }
        }
        
        System.out.println(maxNum);
        
    }
}