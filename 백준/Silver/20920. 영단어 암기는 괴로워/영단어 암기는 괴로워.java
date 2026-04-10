import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 1. 빠른 입력을 위한 세팅
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashMap<String, Integer> wordMap = new HashMap<>();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            
            if (word.length() >= M) {
                wordMap.put(word, wordMap.getOrDefault(word,0) + 1);
            }
        }
        List<String> words = new ArrayList<>(wordMap.keySet());

        words.sort((w1, w2) -> {
            int c1=wordMap.get(w1);
            int c2=wordMap.get(w2);
            if (c1 != c2) return c2 - c1; //자주 나오는 단어
            if (w1.length() != w2.length()) return w2.length() - w1.length(); //길이가 길수록
            return w1.compareTo(w2); //알파벳 사전 순
        });
        
        StringBuilder sb = new StringBuilder();
        
        for (String word : words){
            sb.append(word+"\n");
        }
        System.out.println(sb.toString());
        // 
    }
}