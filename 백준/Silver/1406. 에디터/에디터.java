import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
    	LinkedList<Character> list = new LinkedList<>();
    	ListIterator<Character> iter = list.listIterator();
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	StringBuilder sb= new StringBuilder();
    	
    	String input = br.readLine();
    	for (char c : input.toCharArray()) {
    	    iter.add(c);
    	}
    	
    	int N = Integer.parseInt(br.readLine());
    	for (int i=0;i<N;i++) {
    		st = new StringTokenizer(br.readLine());
    		String cmd = st.nextToken();
    		
    		if (cmd.equals("L")) {
    	        if (iter.hasPrevious()) iter.previous();
    	    }
    		else if (cmd.equals("D")) {
    	        if (iter.hasNext()) iter.next();
    	    } 
    		else if (cmd.equals("B")) {
    			if (iter.hasPrevious()) {
    	            iter.previous();
    	            iter.remove();
    	        }
    	    } 
    		else {
    			String val = st.nextToken();
    	        iter.add(val.charAt(0));
    	    }
    		
    	}
    	for (char c : list) {
	        sb.append(c);
	    }
	    sb.append("\n");
    	
        
        System.out.println(sb.toString());
        br.close();
    } // main

} // class