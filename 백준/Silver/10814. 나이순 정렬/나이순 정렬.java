import java.util.*;
import java.io.*;

public class Main {
    // 나이와 이름을 담을 클래스
    static class Member {
        int age;
        String name;
        int order; // 입력받은 순서 (Stable Sort를 위해)

        public Member(int age, String name, int order) {
            this.age = age;
            this.name = name;
            this.order = order;
        }
        
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        Member[] members = new Member[N];
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            members[i] = new Member(age, name, i);
        }
        
        Arrays.sort(members, (a,b)->{
        	if (b.age!=a.age) {
        		return a.age-b.age;
        	}
        	else {
        		return a.order - b.order;
        	}
        	
        });																																																																																																																																																																																																																																																																																																		

        for (Member m: members) {
        	System.out.printf("%d %s\n",m.age,m.name);
        }
    }
}