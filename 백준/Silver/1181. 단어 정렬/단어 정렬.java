import java.util.*;
import java.io.*;


public class Main {
	
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//      StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        
        HashSet<String> set = new HashSet<>();
        
        
        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }
        
        String[] words = set.toArray(new String[0]);
        
        Arrays.sort(words,(a,b)->{
        	if(a.length()==b.length()) {
        		return a.compareTo(b);
        	}
        	return a.length()-b.length();
        });																																																																																																																																																																																																																																																																																													

        for (String word: words) {
        	sb.append(word).append("\n");
        }
        System.out.println(sb.toString());
    }
}