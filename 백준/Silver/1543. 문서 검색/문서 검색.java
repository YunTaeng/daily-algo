import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String target = sc.nextLine();
        String replaced = str.replace(target, "");
        System.out.println((str.length()-replaced.length())/target.length());
    }
}