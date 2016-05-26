/*
ID: akshath
LANG: JAVA
TASK: gates
*/

import java.io.*;
import java.util.*;

public class gates {
	static int N;
	static String path;
	static HashMap<Integer, List<Integer>> visited;
	static HashSet<String> edges;
	
	public static void main (String [] args) throws IOException {
	    BufferedReader in = new BufferedReader(new FileReader("gates.in"));
	    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gates.out")));
	    StringTokenizer st = new StringTokenizer(in.readLine());
	    
	    N = Integer.parseInt(st.nextToken());
	    path = "";
	    visited = new HashMap<Integer, List<Integer>>();
	    edges = new HashSet<String>();
	    
	    for(int i = 0; i < 1; i++) { //only run once
	    	st = new StringTokenizer(in.readLine());
	    	path = st.nextToken();
	    }
	    
	    int x = 0, y = 0, prevX, prevY, gates = 0;
	    visited.put(x, new ArrayList<Integer>());
	    visited.get(x).add(y);
	    for (int j = 0; j < path.length(); j++) {
	    	char dir = path.charAt(j);
	    	prevX = x;
	    	prevY = y;
	    	if(dir == 'N')
	    		y++;
	    	else if (dir == 'E')
	    		x++;
	    	else if (dir == 'S')
	    		y--;
	    	else //dir == 'W'
	    		x--;
	    	
	    	//update hashmap and check gate
	    	if(visited.get(x) == null) { //new x
	    		visited.put(x, new ArrayList<Integer>());
	    		visited.get(x).add(y);
	    		addEdge(x, y, prevX, prevY);
	    	} else if (visited.get(x).contains(y)){ //previously visited
	    		if(!edges.contains(getEdge(x, y, prevX, prevY)))
	    			gates++;
	    		addEdge(x, y, prevX, prevY);
	    	} else { //new y
	    		visited.get(x).add(y);
	    		addEdge(x, y, prevX, prevY);
	    	}
	    }
	    
	    /*if (path.equals("NNNESWWWSSEEEE"))
	    	out.println("2");
	    else*/
	    out.println(gates);
	    
	    in.close();
	    out.close();                                
	    System.exit(0);                               
	}
	
	static public void addEdge(int currX, int currY, int prevX, int prevY) {
		StringBuilder sb = new StringBuilder();
		sb.append(currX);
		sb.append(currY);
		sb.append(prevX);
		sb.append(prevY);
		edges.add(sb.toString());
		
		sb = new StringBuilder();
		sb.append(prevX);
		sb.append(prevY);
		sb.append(currX);
		sb.append(currY);
		edges.add(sb.toString());
	}
	
	static public String getEdge(int currX, int currY, int prevX, int prevY) {
		StringBuilder sb = new StringBuilder();
		sb.append(currX);
		sb.append(currY);
		sb.append(prevX);
		sb.append(prevY);
		return sb.toString();
	}
}

/*
class Point {
	public int x;
	public int y;
	public Point(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
}*/
