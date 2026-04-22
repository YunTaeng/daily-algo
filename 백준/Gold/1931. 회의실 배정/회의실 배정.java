import java.io.*;
import java.util.*;
public class Main {
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int [][]input=new int[N][2];
        int cnt=0;
        int now=0;
        
        for ( int i =0; i<N ; i++) {
        	st=new StringTokenizer(br.readLine());
        	input[i][0]=Integer.parseInt(st.nextToken());
        	input[i][1]=Integer.parseInt(st.nextToken());
        }
		
        Arrays.sort(input,(a,b)->{
        	if (a[1]==b[1]) {
        		return a[0]-b[0];
        	}
        	else {
        		return a[1]-b[1];
        	}
        });
        
        
        
        for ( int i =0; i<N ; i++) {
        	if (input[i][0] >= now) {
        		cnt+=1;
        		now=input[i][1];
        	}
        }
        System.out.println(cnt);
	} // main
	
} // class

