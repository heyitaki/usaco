/*
ID: akshath
LANG: JAVA
TASK: hopscotch
*/

import java.io.*;
import java.util.*;

public class hopscotch {
	static int[][] board;
	static int[][] moves;
	static int R, C;
	
	public static void main (String [] args) throws IOException {
	    BufferedReader in = new BufferedReader(new FileReader("hopscotch.in"));
	    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("hopscotch.out")));
	    StringTokenizer st = new StringTokenizer(in.readLine());
	    
	    R = Integer.parseInt(st.nextToken());
	    C = Integer.parseInt(st.nextToken());
	    int K = Integer.parseInt(st.nextToken());
	    
	    /*int[] board = new int[R*C];
	    for(int i = 0; i < R * C; i++)
	    {
	    	if(i % R == 0)
	    		st = new StringTokenizer(in.readLine());
	    	board[i] = Integer.parseInt(st.nextToken());;
	    }*/
	    
	    board = new int[R][C];
	    moves = new int[R][C];
	    for(int i = 0; i < R; i++)
	    {
	    	st = new StringTokenizer(in.readLine());
	    	for(int j = 0; j < C; j++)
	    	{
	    		board[i][j] = Integer.parseInt(st.nextToken());
	    		moves[i][j] = -1;
	    	}
	    }
	    
	    out.println(numHops(0,0));
	    
	    in.close();
	    out.close();                                
	    System.exit(0);                               
	  }
	
	public static int numHops(int startRow, int startCol)
	{
		int total = 0;
		if(R - 1 == startRow && C - 1 == startCol)
		{
			moves[startRow][startCol] = 1;
			return 1;
		}
		else if(R - 1 == startRow || C - 1 == startCol)
		{
			moves[startRow][startCol] = 0;
			return 0;
		}
		else
		{
			for(int i = startRow + 1; i < R; i++)
			{
				for(int j = startCol + 1; j < C; j++)
				{
					if(board[i][j] != board[startRow][startCol])
					{
						if(moves[i][j] != -1)
							total += moves[i][j];
						else
							total += numHops(i, j);
						total %= 1000000007;
					}
				}
			}
		}
		moves[startRow][startCol] = total;
		return total;
	}
}
