/*
ID: akshath
LANG: JAVA
TASK: censor
*/

import java.io.*;
import java.util.*;

public class censor {
	static char[] article;
	static char[] word;
	
	public static void main (String [] args) throws IOException {
	    BufferedReader in = new BufferedReader(new FileReader("censor.in"));
	    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("censor.out")));
	    StringTokenizer st = new StringTokenizer(in.readLine());
	    
	    String orig = st.nextToken();
	    st = new StringTokenizer(in.readLine());
	    String del = st.nextToken();
	    
	    int length = orig.length();
	    boolean hasChanged = true;
	    
	    while(hasChanged)
	    {
	    	orig = orig.replaceAll(del, "");
	    	if(length != orig.length())
	    	{
	    		hasChanged = true;
	    		length = orig.length();
	    	}
	    	else
	    		hasChanged = false;
	    }
	    
	    out.println(orig);
	    
	    /*
	    word = del.toCharArray();
	    article = orig.toCharArray();
	    
	    int articleLength = article.length;
	    int wordLength = word.length;
	    
	    int pointer = 0;
	    
	    while(pointer < articleLength)
	    {
		    if(article[pointer] != word[0])
		    {
		    	pointer++;
		    }
		    else
		    {
			    int num = compare(pointer);
			    if(num != 0)
			    {
			    	deleteWord(pointer, num);
			    	if(pointer - wordLength < 0)
			    		pointer = 0;
			    	else
			    		pointer -= wordLength;
			    }
			    else
			    	pointer++;
		    }
	    }
	       
	    int count = 0;
	    while(count < articleLength)
	    {
	    	while(article[count] == '1')
	    	{
	    		count++;
	    	}
	    	if(article[count] != '1')
	    	{
	    		out.print(article[count]);
	    		count++;
	    	}
	    	
	    }
	    out.println("");*/
	    
	    in.close();
	    out.close();                                
	    System.exit(0);                               
	  }
	
	public static int compare(int start)
	{
		int count = 0;
		for(int i = 0; i < word.length; i++)
		{
			while((start + count <= article.length - 1) && (article[start + count] == '1'))
				count++;
			if((start + count <= article.length - 1) && (article[start + count] != word[i]))
				return 0;
			count++;
		}
		return count;
	}
	
	public static void deleteWord(int start, int length)
	{
		for(int i = 0; i < length; i++)
		{
			article[start + i] = '1';
		}
	}
	/*public String delete(int start)
	{
		String local = "";
		int count = 0;
		if(start >= orig.length())
			return local;
		for(int i = 0; i < word.length; i++)
		{
			char nextChar = orig.charAt(start + i);
			if(nextChar == word[i])
			{
				local += nextChar;
			}
		}
		return null;
	}*/
}
