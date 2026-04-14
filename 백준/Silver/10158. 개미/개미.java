import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        
        int W = sc.nextInt();
        int H = sc.nextInt();
        int P = sc.nextInt();
        int Q = sc.nextInt();
        int T = sc.nextInt();

        int timeX = T % (2 * W);
        int currentX = P;
        int deltaX=1;
        while (timeX-- > 0 ){
            if (currentX ==W) deltaX = -1;
            else if(currentX ==0) deltaX = 1;
            currentX+=deltaX;
        }

        int timeY = T % (2 * H);
        int currentY = Q;
        int deltaY=1;
        while (timeY-- > 0 ){
            if (currentY ==H) deltaY = -1;
            else if(currentY ==0) deltaY = 1;
            currentY+=deltaY;
        }

        System.out.printf("%d %d",currentX,currentY);
    }
}