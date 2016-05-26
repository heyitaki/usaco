/*
ID: akshath2
LANG: JAVA
TASK: meeting
*/

import java.io.*;
import java.util.*;

public class meeting {
	public static void main (String [] args) throws IOException {
	    BufferedReader in = new BufferedReader(new FileReader("meeting.in"));
	    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("meeting.out")));
	    StringTokenizer st = new StringTokenizer(in.readLine());
	    
	    int dest = Integer.parseInt(st.nextToken());
	    int m = Integer.parseInt(st.nextToken());
	    HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
	    
	    for(int i = 0; i < m; i++)
	    {
	    	st = new StringTokenizer(in.readLine());
	    	int start = Integer.parseInt(st.nextToken());
	 	    int end = Integer.parseInt(st.nextToken());
	 	    int timeBessie = Integer.parseInt(st.nextToken());
	 	    int timeElsie = Integer.parseInt(st.nextToken());
	    	hm.put(100 * start + dest, timeBessie * 10000 + timeElsie);
	    	
	    	
	    }
	    
	    in.close();
	    out.close();                                
	    System.exit(0);                               
	  }
	private static void findPath(HashMap<Integer, Integer> hm)
	{
		for(int a = 0; a < 16; a++)
		{
			for(int b = 1; b < 16; b++)
			{
				for(int c = 2; c < 16; c++)
				{
					for(int d = 3; d < 16; d++)
					{
						for(int e = 4; e < 16; e++)
						{
							for(int f = 5; f < 16; f++)
							{
								for(int g = 6; g < 16; g++)
								{
									for(int h = 7; h < 16; h++)
									{
										for(int i = 8; i < 16; i++)
										{
											for(int j = 9; j < 16; j++)
											{
												for(int k = 10; k < 16; k++)
												{
													for(int l = 11; l < 16; l++)
													{
														for(int m = 12; m < 16; m++)
														{
															for(int n = 13; n < 16; n++)
															{
																for(int o = 14; o < 16; o++)
																{
																	for(int p = 15; p < 16; p++)
																	{
																		
																	}
																}
																
															}
														}
													}
												}
												
											}
										}
									}
								}
								
							}
						}
					}
				}
				
			}
		}
	}
}
