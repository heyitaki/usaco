/*
ID: akshath
LANG: JAVA
TASK: frame
*/

import java.io.*;
import java.util.*;

public class frame {
	public static void main (String [] args) throws IOException {
	    BufferedReader in = new BufferedReader(new FileReader("frame.in"));
	    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("frame.out")));
	    StringTokenizer st = new StringTokenizer(in.readLine());
	    
	    
	    in.close();
	    out.close();                                
	    System.exit(0);                               
	  }
}
