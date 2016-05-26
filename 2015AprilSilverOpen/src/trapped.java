/*
ID: akshath
LANG: JAVA
TASK: trapped
*/

import java.io.*;
import java.util.*;

public class trapped {
	public static void main (String [] args) throws IOException {
	    BufferedReader in = new BufferedReader(new FileReader("trapped.in"));
	    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("trapped.out")));
	    StringTokenizer st = new StringTokenizer(in.readLine());
	    
	    int numBales = Integer.parseInt(st.nextToken());
	    int startPos = Integer.parseInt(st.nextToken());
	    
	    for(int i = 0; i < numBales; i++) {
	    	st = new StringTokenizer(in.readLine());
	    	
	    }
	    
	    
	    in.close();
	    out.close();                                
	    System.exit(0);                               
	  }
}
