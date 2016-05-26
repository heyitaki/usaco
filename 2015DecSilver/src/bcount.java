/*
ID: akshath
LANG: JAVA
TASK: bcount
*/

import java.io.*;
import java.util.*;

public class bcount {
	public static void main (String [] args) throws IOException {
	    BufferedReader in = new BufferedReader(new FileReader("bcount.in"));
	    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("bcount.out")));
	    StringTokenizer st = new StringTokenizer(in.readLine());
	    
	    int n = Integer.parseInt(st.nextToken());
	    int q = Integer.parseInt(st.nextToken());
	    
	    //initial set-up
	    int[] breed1 = new int[n + 1];
	    int[] breed2 = new int[n + 1];
	    int[] breed3 = new int[n + 1];
	    int num1 = 0;
	    int num2 = 0;
	    int num3 = 0;
	    int breed = 0;
	    breed1[0] = 0;
    	breed2[0] = 0;
    	breed3[0] = 0;
	    for(int i = 1; i < n + 1; i++) {
	    	st = new StringTokenizer(in.readLine());
	    	breed = Integer.parseInt(st.nextToken());
	    	if(breed == 1) {
	    		num1++;
	    	} else if(breed == 2) {
	    		num2++;
	    	} else {
	    		num3++;
	    	}
	    	
	    	breed1[i] = num1;
	    	breed2[i] = num2;
	    	breed3[i] = num3;
	    }
	    
	    for(int j = 0; j < q; j++) {
	    	st = new StringTokenizer(in.readLine());
	    	int start = Integer.parseInt(st.nextToken());
		    int end = Integer.parseInt(st.nextToken());
		    
		    int result1, result2, result3;
		    result1 = breed1[end] - breed1[start - 1];
		    result2 = breed2[end] - breed2[start - 1];
		    result3 = breed3[end] - breed3[start - 1];

		    out.println(result1 + " " + result2 + " " + result3);
	    }
	    
	    in.close();
	    out.close();                                
	    System.exit(0);                               
	  }
}
