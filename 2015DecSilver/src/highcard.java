/*
ID: akshath
LANG: JAVA
TASK: highcard
*/

import java.io.*;
import java.util.*;

public class highcard {
	public static void main (String [] args) throws IOException {
	    BufferedReader in = new BufferedReader(new FileReader("highcard.in"));
	    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("highcard.out")));
	    StringTokenizer st = new StringTokenizer(in.readLine());
	    
	    int N = Integer.parseInt(st.nextToken());
	    
	    ArrayList<Integer> cards = new ArrayList<Integer>();
	    for(int i = 0; i < N; i++) {
	    	st = new StringTokenizer(in.readLine());
	    	cards.add(Integer.parseInt(st.nextToken()));
	    }
	    
	    Collections.sort(cards);
	    
	    int result = 0;
	    int prev = N * 2;
	    int lengthLeft = N;
	    int inc;
	    int count = 1;
	    for(int j = cards.size() - 1; j >= 0; j--) {
	    	if (j == cards.size() - 1) {
	    		inc = prev - cards.get(j);
	    		result += inc;
	    	} else {
	    		inc = prev - cards.get(j) - 1;
	    		if (inc < lengthLeft) {
	    			result += inc;
	    		} else {
	    			result += lengthLeft;
	    			break;
	    		}
	    	}
	    	if (inc == 0 && count > N - lengthLeft) {
	    		lengthLeft -= 1;
	    	} else {
	    		lengthLeft -= inc;
	    	}
	    	count++;
	    	prev = cards.get(j);
	    }
	    
	    out.println(result);
	    
	    in.close();
	    out.close();                                
	    System.exit(0);                               
	  }
}
