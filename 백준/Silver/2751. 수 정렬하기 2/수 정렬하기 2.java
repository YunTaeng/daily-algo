import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//      StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        
        int [] input=new int[N];
        
        for (int i = 0; i < N; i++) {
            
            input[i]= Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(input);																																																																																																																																																																																																																																																																																													

        for (Integer i: input) {
        	sb.append(i).append("\n");
        }
        System.out.println(sb.toString());
    }
}