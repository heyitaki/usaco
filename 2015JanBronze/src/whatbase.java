/*
ID: akshath2
LANG: JAVA
TASK: whatbase
*/

import java.io.*;
import java.util.*;

public class whatbase {
	public static void main (String [] args) throws IOException {
	    BufferedReader in = new BufferedReader(new FileReader("whatbase.in"));
	    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("whatbase.out")));
	    StringTokenizer st = new StringTokenizer(in.readLine());
	    
	    int n = Integer.parseInt(st.nextToken());
	    long answer1;
	    	    
	    for(int i = 0; i < n; i++)
	    {
	    	HashMap<Long, Long> hm = new HashMap<Long, Long>();
	    	st = new StringTokenizer(in.readLine());
	    	int num1 = Integer.parseInt(st.nextToken());
	    	int num2 = Integer.parseInt(st.nextToken());
	    	
	    	for(int x = 11; x < 15000; x++)
	    	{
	    		answer1 = (num1 / 100) * x * x + ((num1 % 100) / 10) * x + (num1 % 10);
	    		hm.put(answer1, (long)x);
	    	}
	    	
	    	for(int x = 11; x < 15000; x++)
	    	{
	    		long answer2 = (num2 / 100) * x * x + ((num2 % 100) / 10) * x + (num2 % 10);
	    		if(hm.containsKey(answer2))
	    		{
	    			out.println(hm.get(answer2) + " " + x);
	    			break;
	    		}
	    	}
	    	

	    }
	    
	    
	    in.close();
	    out.close();                                
	    System.exit(0);                               
	  }
}
