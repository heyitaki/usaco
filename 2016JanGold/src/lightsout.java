/*
ID: akshath
LANG: JAVA
TASK: lightsout
*/

import java.io.*;
import java.util.*;

class lightsout{
    static int N;

    public static void main(String[] args) throws IOException {
        class Node {
            public int distance, optimaldistance;
            public char angle;
            public StringBuilder key = new StringBuilder();
            public boolean found = false;
            public int x,y;
            public Node (int x, int y, int distance) {
                this.x = x; this.y = y; this.distance = distance;
            }
        }

        BufferedReader in = new BufferedReader(new FileReader("lightsout.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lightsout.out")));
        StringTokenizer st = new StringTokenizer(in.readLine());
        
        N = Integer.parseInt(st.nextToken());
        
        Node[] nodes = new Node[N+2];
        
        int prev, next;
        Node nprev = null, n, nnext;
        int distance = 0;
        int total = 0;
        for (int i = 1; i <= N; i++) {
        	st = new StringTokenizer(in.readLine());
            int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
            if (nprev != null) {
                if (x == nprev.x) {
                    distance = Math.abs(y - nprev.y);
                } else {
                    distance = Math.abs(x - nprev.x);
                }
                total += distance;
                nprev = new Node(x, y, nprev.distance + distance);
            } else {
                nprev = new Node(x, y, 0);
            }
            nodes[i] = nprev;
        }
        nodes[0] = nodes[N];
        nodes[N+1] = nodes[1];
        nodes[1].optimaldistance = 0;
        total += Math.abs(nodes[N].x - nodes[1].x) + Math.abs(nodes[N].y - nodes[1].y);
        
        for (int i=1; i<=N; i++) {
            prev = i -1; next = i + 1;
            nprev = nodes[prev]; n = nodes[i]; nnext = nodes[next];
            
            n.optimaldistance = (total - n.distance < n.distance)?total - n.distance:n.distance; 
            
            if (n.x == nprev.x) {
                if (nprev.y < n.y) {// up
                    n.angle = nnext.x > n.x?'R':'L';
                } else { // down
                    n.angle = nnext.x < n.x?'R':'L';
                }
            } else {
                if (nprev.x < n.x) {// right
                    n.angle = nnext.y < n.y?'R':'L';
                } else { // left
                    n.angle = nnext.x > n.x?'R':'L';
                }
            }
        }
        
        Node nn;
        int maxdelta = 0;
        for (int i=0; i<N; i++) {
            HashMap<String, Integer> keyCount = new HashMap<String, Integer>();
            for (int j=2; j+i <= N+1; j++) {
                n = nodes[j];
                
                if (!n.found) {
                    if (i == 0) {
                        n.key.append(n.angle); 
                    } else {
                        nn = nodes[j+i];
                        n.key.append(".");
                        n.key.append(nn.distance - nodes[i+j-1].distance); 
                        n.key.append(nn.angle); 
                    }
                    if (keyCount.containsKey(n.key.toString())) {
                        keyCount.put(n.key.toString(), keyCount.get(n.key.toString())+1);
                    } else {
                        keyCount.put(n.key.toString(), 1);
                    }
                }
            }
            
            for (int j=2; j <= N; j++) {
                n = nodes[j];
                if (j+i == N+1) {
                    n.found = true;
                    int delta = total - n.distance;
                    delta = Math.abs(delta - n.optimaldistance);
                    if (maxdelta < delta) maxdelta = delta;
                    break;
                } else if (!n.found && keyCount.get(n.key.toString()) == 1) { // unique
                    n.found = true;
                    if (i > 0) {
                        int delta = 0;
                        for (int k=1; k<= i; k++)
                            delta += nodes[j+k].distance - nodes[j+k-1].distance;
                        nn = nodes[j+i];
                        delta = Math.abs(delta + nn.optimaldistance - n.optimaldistance);
                        if (maxdelta < delta) maxdelta = delta;
                    }
                }
            }
        }
        
        out.println(maxdelta);
        
        in.close();
        out.close();                            
	    System.exit(0);
    }
}