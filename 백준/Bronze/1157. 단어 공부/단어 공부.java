import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        String stra = sc.next();
        
        int[] cnta = new int[26];

        for (int i =0; i<stra.length();i++){
            char ch = stra.charAt(i);
            if ('a'<= ch && ch <='z') cnta[ch-'a']+=1;
            else cnta[ch-'A']+=1;
        }

        char maxAlphabet='?';
        int maxcnt=-1;
        for (int i =0; i<26;i++){
            if (cnta[i]>maxcnt){
                maxcnt = cnta[i];
                maxAlphabet=(char)('A'+i);
            }
            else if  (cnta[i]==maxcnt){
                maxAlphabet='?';
            }
        }
        System.out.println(maxAlphabet);
        // int N = Integer.parseInt(st.nextToken());

        
        
        
        
        
        
        System.out.println(sb.toString());
        // 
    }
}