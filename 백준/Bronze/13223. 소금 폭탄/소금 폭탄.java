import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        
        String[] a = sc.nextLine().split(":");
        String[] b = sc.nextLine().split(":");
        int curTime = Integer.parseInt(a[0])*60*60+Integer.parseInt(a[1])*60+Integer.parseInt(a[2]);
        int targetTime=Integer.parseInt(b[0])*60*60+Integer.parseInt(b[1])*60+Integer.parseInt(b[2]);
        
        int timeDiff = targetTime - curTime;
        
        if (timeDiff <= 0) {
            timeDiff += 24 * 3600;
        }

        int hh = timeDiff / 3600;
        int mm = (timeDiff % 3600) / 60;
        int ss = timeDiff % 60;
        System.out.printf("%02d:%02d:%02d",hh,mm,ss);
    }
}