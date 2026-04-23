import java.util.*;
import java.io.*;

public class Main { // KMP법에 의한 문자열 검색
	public static List<Integer> idxList = new ArrayList<>();
	public static int K=0;
	
    public static void kmpMatch(String txt, String pat) {
        int pt = 1;                                // txt를 따라가는 커서
        int pp = 0;                                // pat를 따라가는 커서
        int[] skip = new int[pat.length() + 1];    // 건너뛰기 표(skip 테이블)

        // skip 테이블 작성
        skip[pt] = 0;
        while (pt != pat.length()) {
            if (pat.charAt(pt) == pat.charAt(pp))
                skip[++pt] = ++pp;
            else if (pp == 0)
                skip[++pt] = pp;
            else
                pp = skip[pp];
        }
        // 검색
        pt = pp = 0;
        
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
                pp = skip[pp];//????
            }
        }
    }

    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    	StringTokenizer st = new StringTokenizer(br.readLine());

        String s1 = br.readLine();                 // 텍스트용 문자열

        String s2 = br.readLine();                     // 패턴용 문자열

        kmpMatch(s1, s2);    // 문자열 s1에서 문자열 s2를 브루트-포스법으로 검색

        System.out.println(idxList.size());
        StringBuilder sb = new StringBuilder();
        for (int idx : idxList) {
            sb.append(idx).append(" ");
        }
        System.out.println(sb.toString());

        br.close();
    } // main

} // class