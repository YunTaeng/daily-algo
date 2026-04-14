import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        
        for (int i =0; i<str.length();i++){
            char ch = str.charAt(i);
            if ('A'<=ch && ch <='Z'){
                sb.append((char)(ch+'a'-'A'));
            }
            else{
                sb.append((char)(ch+'A'-'a'));
            }

        }

        // int N = Integer.parseInt(st.nextToken());

        
        
        
        
        
        
        System.out.println(sb.toString());
        // 
    }
}