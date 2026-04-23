import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
    	
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    	StringTokenizer st=new StringTokenizer(br.readLine());
    	StringBuilder sb= new StringBuilder();
    	
    	
    	int N = Integer.parseInt(br.readLine());
        
        for (int t = 0 ;t<N;t++) {
        	LinkedList<Character> list = new LinkedList<>();
        	ListIterator<Character> iter = list.listIterator();
        	String input = br.readLine();
        	for (char c : input.toCharArray()) {
        		if (c == '<') {
        	        if (iter.hasPrevious()) iter.previous();
        	    } else if (c == '>') {
        	        if (iter.hasNext()) iter.next();
        	    } else if (c == '-') {
        	        if (iter.hasPrevious()) {
        	            iter.previous();
        	            iter.remove();
        	        }
        	    } else {
        	        iter.add(c);
        	    }
        		
        	}
        	for (char c : list) {
    	        sb.append(c);
    	    }
    	    sb.append("\n");
        	
        }//for_i
        
        System.out.println(sb.toString());
        br.close();
    } // main

} // class