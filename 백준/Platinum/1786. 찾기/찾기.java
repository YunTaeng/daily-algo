import java.util.*;
import java.io.*;

class Main { // KMP법에 의한 문자열 검색
	static List<Integer> idxList = new ArrayList<>();
	static int K=0;
	static int[] skip;
	
	private static void makeSkip(String pat) {
    	int pt = 1;
        int pp = 0; 
		skip[pt] = 0;
        while (pt != pat.length()) {
            if (pat.charAt(pt) == pat.charAt(pp))//문자가 같으면
                skip[++pt] = ++pp;
            else if (pp == 0) //문자가 다른경우 - 맨 처음부터 다름
                skip[++pt] = pp;
            else // 문자가 다른경우 - 몇 개 같다가 중간부터 다른경우
                pp = skip[pp];
        }
	}
	
    private static void kmpMatch(String txt, String pat) {
        int pt = 0;
        int pp = 0;
        
        while (pt != txt.length()) {
            if (txt.charAt(pt) == pat.charAt(pp)) {
                pt++;
                pp++;
            } else if (pp == 0)
                pt++;
            else
                pp = skip[pp];
            
            if (pp == pat.length()) {
                idxList.add(pt - pp + 1); 
                pp = skip[pp];
            }
        }
    }

    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s1 = br.readLine(); // 텍스트용
        String s2 = br.readLine(); // 패턴용
        
        skip=new int[s2.length() + 1];
        
        makeSkip(s2);
        kmpMatch(s1, s2); // 문자열 s1에서 문자열 s2를 브루트-포스법으로 검색

        System.out.println(idxList.size());
        StringBuilder sb = new StringBuilder();
        for (int idx : idxList) {
            sb.append(idx).append(" ");
        }
        System.out.println(sb.toString());

        br.close();
    } // main
    
    
} // class
