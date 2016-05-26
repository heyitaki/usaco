/*
ID: akshath
LANG: JAVA
TASK: radio
*/

import java.io.*;
import java.util.*;

public class radio {
	static int N, M, fxStart, fyStart, bxStart, byStart;
    static String fSteps, bSteps;
    static int[][] distanceSq; //only use squared distances
    static int[][] savedDist; //eliminates repeat recursion
    
	public static void main (String [] args) throws IOException {
	    BufferedReader in = new BufferedReader(new FileReader("radio.in"));
	    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("radio.out")));
	    StringTokenizer st = new StringTokenizer(in.readLine());
	    
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(in.readLine());
        fxStart = Integer.parseInt(st.nextToken());
        fyStart = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(in.readLine());
        bxStart = Integer.parseInt(st.nextToken());
        byStart = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(in.readLine());
        fSteps = st.nextToken();
        st = new StringTokenizer(in.readLine());
        bSteps = st.nextToken();
        
        int fxNext = fxStart; 
        int fyNext = fyStart;
        int bxNext = bxStart; 
        int byNext = byStart;
        char fNextStep, bNextStep;
        distanceSq = new int[N+1][M+1];
        savedDist = new int[N+1][M+1];
        savedDist = init2DArray(savedDist);
        
        int m = 0, n = 0;
        fSteps = " " + fSteps; //filler
        
        for(int k = 1; k < N+1; k++) {
        	fNextStep = fSteps.charAt(k);
        	if(fNextStep == 'N')
    			fyNext++;
    		else if(fNextStep == 'E')
    			fxNext++;
    		else if(fNextStep == 'S')
    			fyNext--;
    		else if(fNextStep == 'W')
    			fxNext--;
        	distanceSq[k][0] = Math.abs(fyNext - byStart) * Math.abs(fyNext - byStart) + Math.abs(fxNext - bxStart) * Math.abs(fxNext - bxStart);
        }
        
        fxNext = fxStart; 
    	fyNext = fyStart;
        while(m < N+1) {
        	fNextStep = fSteps.charAt(m);
    		if(fNextStep == 'N')
    			fyNext++;
    		else if(fNextStep == 'E')
    			fxNext++;
    		else if(fNextStep == 'S')
    			fyNext--;
    		else if(fNextStep == 'W')
    			fxNext--;
    		
    		n = 0;
        	while(n < M) {
        		n++;
        		bNextStep = bSteps.charAt(n-1);
        		if(bNextStep == 'N')
        			byNext++;
        		else if(bNextStep == 'E')
        			bxNext++;
        		else if(bNextStep == 'S')
        			byNext--;
        		else if(bNextStep == 'W')
        			bxNext--;
        		
        		distanceSq[m][n] = (int) (Math.pow(Math.abs(fyNext - byNext), 2) + Math.pow(Math.abs(fxNext - bxNext), 2));
        	}
        	bxNext = bxStart; 
        	byNext = byStart;
        	m++;
        }
        
        int optimalSol = getBestPath(distanceSq, N, M);
        out.println(optimalSol);
	    
	    in.close();
	    out.close();                                
	    System.exit(0);                               
	}
	
	public static final int ARRAY_INIT_VAL = -1;
	public static int[][] init2DArray(int[][] input) {
		for(int i = 0; i < input.length; i++) {
        	for(int j = 0; j < input[0].length; j++) {
        		input[i][j] = ARRAY_INIT_VAL;
        	}
        }
		return input;
	}
	
	public static int tripleMin(int x, int y, int z) {
		return (x < y) ? ((x < z) ? x : z) : ((y < z) ? y : z);
	}
	
	//dynamic programming the best way>????
    public static int getBestPath(int[][] input, int m, int n) {
    	if(savedDist[m][n] != ARRAY_INIT_VAL)
    		return savedDist[m][n];
    	
    	if (m <= 0 && n <= 0)
    		return input[0][0];
    	else if (m == 0) { //no diagonal, horizontal
    		savedDist[m][n] = input[m][n] + getBestPath(input, m, n-1);
    	} else if (n == 0) { //no diagonal, vertical	
    		savedDist[m][n] = input[m][n] + getBestPath(input, m-1, n);
    	} else { //diagonal, vertical, horizontal
    		savedDist[m][n] = input[m][n] + tripleMin(getBestPath(input, m, n-1), getBestPath(input, m-1, n-1), getBestPath(input, m-1, n));
    	}
    	return savedDist[m][n];
    }
}
