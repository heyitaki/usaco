/*
ID: akshath
LANG: JAVA
TASK: angry
*/

import java.io.*;
import java.util.*;

public class angry {
	static int N;
	static int[] bales, dist, interval;
	static double[] forward, backward;
	
	public static void main (String [] args) throws IOException {
	    BufferedReader in = new BufferedReader(new FileReader("angry.in"));
	    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("angry.out")));
	    StringTokenizer st = new StringTokenizer(in.readLine());
	    
	    N = Integer.parseInt(st.nextToken());
	    bales = new int[N];
	    
	    for(int i = 0; i < N; i++) {
	    	st = new StringTokenizer(in.readLine());
	    	bales[i] = Integer.parseInt(st.nextToken());
	    }
	    
	    Arrays.sort(bales);
	    dist = getDistances(bales);
	    
	    forward = getForward(bales);
	    backward = getBackward(bales);
	    
	    String[] temp = getInterval(forward, backward).split("\\.");
	    interval = new int[temp.length];
	    for(int j = 0; j < temp.length; j++) {
	    	interval[j] = Integer.parseInt(temp[j]);
	    }
	    
	    double result;
	    if(interval.length == 1)
	    	result = interval[0];
	    else {
	    	double minLeft = Math.min(forward[interval[0]], backward[interval[0]]);
	    	double minRight = Math.min(forward[interval[1]], backward[interval[1]]);
	    	result = Math.max(minLeft, minRight) + 1;
	    }
	    
	    out.println(result);	
	    
	    in.close();
	    out.close();                                
	    System.exit(0);                               
	}
	
	public static double[] getForward(int[] bales) {
		double[] ret = new double[bales.length];
		double currPower = 0;
		ret[0] = 0;
		for(int i = 1; i < bales.length; i++) {
			int diff = bales[i] - bales[i-1];
			if(currPower < diff) {
				ret[i] = diff;
				currPower = ret[i];
			} else {
				ret[i] = ret[i-1] + 1;
			}
		}
		return ret;
	}
	
	public static double[] getBackward(int[] bales) {
		double[] ret = new double[bales.length];
		double currPower = 0;
		ret[bales.length-1] = 0;
		for(int i = bales.length-2; i >= 0; i--) {
			int diff = bales[i+1] - bales[i];
			if(currPower < diff) {
				ret[i] = diff;
				currPower = ret[i];
			} else {
				ret[i] = ret[i+1] + 1;
			}
		}
		return ret;
	}
	
	public static String getInterval(double[] forward, double[] backward) {
		int retIndex = -1;
		for(int i = 0; i < forward.length; i++) {
			if(forward[i] >= backward[i]){
				retIndex = i;
				break;
			}
		}
		if(forward[retIndex] == backward[retIndex])
			return Integer.toString(retIndex);
		else
			return Integer.toString(retIndex-1) + "." + Integer.toString(retIndex);
	}
	
	public static int[] reduceArray(int[] input, String dir) {
		if(dir.equals("backward")) {
			for(int i = 0; i < input.length-2; i++) {
				if(backward[i] > input[i+2] - input[i]) {
					
				}
			}
		} else {
			for(int i = 0; i < input.length; i++) {
				if(backward[i] > input[i+2] - input[i]) {
					
				}
			}
		}
		return input;
	}
	
	public static int[] getDistances(int[] input) {
		int[] dist = new int[input.length - 1];
		for(int i = 1; i < input.length; i++) {
			dist[i-1] = input[i] - input[i-1];
		}
		return dist;
	}
}
