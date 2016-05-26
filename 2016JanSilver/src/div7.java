/*
ID: akshath
LANG: JAVA
TASK: div7
*/

import java.io.*;
import java.util.*;

public class div7 {
	public static void main (String [] args) throws IOException {
	    BufferedReader in = new BufferedReader(new FileReader("div7.in"));
	    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("div7.out")));
	    StringTokenizer st = new StringTokenizer(in.readLine());
	    
	    int N = Integer.parseInt(st.nextToken());
	    long[] id = new long[N];
	    long[] runningSum = new long[N+1];
	    
	    for(int i = 0; i < N; i++) {
	    	st = new StringTokenizer(in.readLine());
	    	id[i] = Long.parseLong(st.nextToken()) % 7;
	    }
	    
	    runningSum[0] = 0;
	    for(int j = 1; j < N+1; j++) {
	    	runningSum[j] = (runningSum[j-1] + id[j-1]) % 7;
	    }
	    
	    int result = 0;
	    for(int k = 0; k <= 6; k++) {
	    	result = Math.max(result, findDistance(runningSum, k));
	    }
	    
	    out.println(result);
	    
	    in.close();
	    out.close();                                
	    System.exit(0);                               
	}
	
	public static int findDistance (long[] inputArray, int target) {
		int minIndex = -1, maxIndex = -1;
		for(int i = 0; i < inputArray.length; i++) {
			if(minIndex != -1 && maxIndex != -1)
				break;
			if(inputArray[i] == target && minIndex == -1)
				minIndex = i;
			if(inputArray[inputArray.length - i - 1] == target && maxIndex == -1)
				maxIndex = inputArray.length - i - 1;
		}
		if(minIndex != -1 && maxIndex != -1 && maxIndex > minIndex)
			return maxIndex - minIndex;
		return 0;
	}
}
