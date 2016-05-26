/*
ID: akshath2
LANG: JAVA
TASK: cowroute
*/

import java.io.*;
import java.util.*;

public class cowroute {
	public static void main (String [] args) throws IOException {
	    BufferedReader in = new BufferedReader(new FileReader("cowroute.in"));
	    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowroute.out")));
	    StringTokenizer st = new StringTokenizer(in.readLine());
	    
	    int start  = Integer.parseInt(st.nextToken());
	    int dest = Integer.parseInt(st.nextToken());
	    int planes = Integer.parseInt(st.nextToken());
	    ArrayList<RouteData> data = new ArrayList<RouteData>();
	    int cost;
	    
	    for(int i = 0; i < planes; i++)
	    {
	    	st = new StringTokenizer(in.readLine());
	    	cost = Integer.parseInt(st.nextToken());
	    	int pathLength = Integer.parseInt(st.nextToken());
	    	String path = in.readLine();
	    	data.add(new RouteData(cost, pathLength, path));
	    }
	    
	    int totalCost = -1;
	    for(int i = 0; i < data.size(); i++)
	    {
	    	int[] path = data.get(i).path;
	    	int costStart = data.get(i).cost;
	    	int costDest;
	    	for(int j = 0; j < path.length; j++)
	    	{
	    		if(start == path[j])
	    		{
	    			for(int k = j + 1; k < path.length; k++)
	    			{
	    				if(dest == path[k])
	    				{
	    					if(totalCost == -1 || totalCost > costStart)
	    						totalCost = costStart;
	    					break;
	    				}	
	    				else
	    				{
	    					costDest = getCost(data, k, dest);
	    					if((totalCost == -1 || totalCost > costStart + costDest) && costDest != -1)
	    						totalCost = costStart + costDest;
	    				}
	    			}
	    			break;
	    		}
	    	}
	    }
	    
	    out.println(totalCost);
	    
	    in.close();
	    out.close();                                
	    System.exit(0);                               
	  }

	private static int getCost(ArrayList<RouteData> data, int start, int dest)
	{
	    int minCost = -1;
	    for(int i = 0; i < data.size(); i++)
	    {
	    	int[] path = data.get(i).path;
	    	int cost = data.get(i).cost;
	    	for(int j = 0; j < path.length; j++)
	    	{
	    		if(start == path[j])
	    		{
	    			for(int k = j + 1; k < path.length; k++)
	    			{
	    				if(dest == path[k])
	    				{
	    					if(minCost == -1 || minCost > cost)
	    						minCost = cost;
	    				}	    				
	    			}
	    			break;
	    		}
	    	}	
	    }
	    return minCost;
	}
}

class RouteData 
{
	public int cost;
	public int[] path;
	public RouteData(int cost, int n, String path)
	{
		this.cost = cost;
		String[] temp = path.split(" ");
		this.path = new int[n];
		for(int i = 0; i < n; i++)
		{
			this.path[i] = Integer.parseInt(temp[i]);
		}
	}
}

/*
 * public class cowroute {
	public static void main (String [] args) throws IOException {
	    BufferedReader in = new BufferedReader(new FileReader("cowroute.in"));
	    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowroute.out")));
	    StringTokenizer st = new StringTokenizer(in.readLine());
	    
	    String start  = st.nextToken();
	    String dest = st.nextToken();
	    int planes = Integer.parseInt(st.nextToken());
	    int minCost = -1;
	    int cost;
	    
	    for(int i = 0; i < planes; i++)
	    {
	    	st = new StringTokenizer(in.readLine());
	    	cost = Integer.parseInt(st.nextToken());
	    	int pathLength = Integer.parseInt(st.nextToken());
    		st = new StringTokenizer(in.readLine());

	    	for(int j = 0; j < pathLength; j++)
	    	{
	    		String location = st.nextToken();
	    		if(location.equals(start))
	    		{
	    			for(int k = j + 1; k < pathLength; k++)
	    			{
	    				String location2 = st.nextToken();
	    				if(location2.equals(dest))
	    				{
	    					if(minCost == -1 || minCost > cost)
	    						minCost = cost;
	    				}	    				
	    			}
	    			break;
	    		}
	    	}	
	    }
	    
	    out.println(minCost);
	    
	    in.close();
	    out.close();                                
	    System.exit(0);                               
	  }
}
*/
