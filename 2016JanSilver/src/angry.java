/*
ID: akshath
LANG: JAVA
TASK: angry
*/

import java.io.*;
import java.util.*;

public class angry {
    static int N;
    static int K;
    static int[] list;
    public static void main (String [] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("angry.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("angry.out")));

        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
       
        list = new int[N];
        for (int i=0; i<N; i++) {
            list[i] = Integer.parseInt(in.readLine());
        }
        Arrays.sort(list);
        
        int start = 1;
        int end = list[N-1] - list[0];
        
        if (isPossible(start)) {
            out.println(start);
            out.close();                                
        } else {
            while (true) {
                int mid = (start + end + 1)/2;
                if (start >= end-1 || mid >= end) {
                    out.println(end);
                    out.close();                                
                    break;
                }
                
                if (isPossible(mid)) {
                    end = mid;
                } else {
                    start = mid;
                }
            }
        }
        in.close();
        System.exit(0);                               
      }
    
    public static boolean isPossible (int R) {
        int j = 0;
        for (int i=0; i<K; i++) {
            int end = list[j] + 2*R;
            
            for (j++;j<N && list[j] <= end; j++);
            if (j >= N)
                return true;
        }
        return false;
    }
}