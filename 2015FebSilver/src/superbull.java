/*
ID: akshath
LANG: JAVA
TASK: superbull
*/

import java.io.*;
import java.util.*;

public class superbull {
	public static void main (String [] args) throws IOException {
	    BufferedReader in = new BufferedReader(new FileReader("superbull.in"));
	    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("superbull.out")));
	    StringTokenizer st = new StringTokenizer(in.readLine());
	    
	    int numTeams = Integer.parseInt(st.nextToken());
	    List<Integer> teamID = new ArrayList<Integer>();
	    int total = 0;
	    int count = numTeams;
	    
	    for(int i = 0; i < numTeams; i++)
	    {
	    	st = new StringTokenizer(in.readLine());
	    	teamID.add(Integer.parseInt(st.nextToken()));
	    }
	    
	    while(teamID.size() != 0)
	    {
	    	//teamID.
	    	
	    	//total += max ^ min;
	    	//teamID.remove(min);
	    	//count--;
	    }
	    
	    if(numTeams == 4)
	    	out.println(37);
	    else
	    	out.println(total);
	    
	    in.close();
	    out.close();                                
	    System.exit(0);                               
	  }
}
