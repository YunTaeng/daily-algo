import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i=0;i<T;i++){
            HashMap <String,Integer> map = new HashMap<>();
            int N = sc.nextInt();
            for (int j=0;j<N;j++){
                String cloth = sc.next();
                String type = sc.next();
                map.put(type,map.getOrDefault(type,0)+1);
            }//for문_J
            int ans = 1;
            for (Integer v : map.values()){
                ans*=v+1;
            }
            System.out.println(ans-1);
        }//for문_T
    }//main
}//class