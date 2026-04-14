import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        String stra = sc.next();
        String strb = sc.next();
        
        int[] cnta = new int[26];
        int[] cntb = new int[26];

        for (int i =0; i<stra.length();i++){
            char ch = stra.charAt(i);
            cnta[ch-'a']+=1;
        }
        for (int i =0; i<strb.length();i++){
            char ch = strb.charAt(i);
            cntb[ch-'a']+=1;
        }
        int cnt=0;
        for (int i =0; i<26;i++){
            cnt+=Math.abs(cnta[i]-cntb[i]);
        }
        System.out.println(cnt);
        // int N = Integer.parseInt(st.nextToken());

        
        
        
        
        
        
        System.out.println(sb.toString());
        // 
    }
}