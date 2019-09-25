# Shorteset Path

## I. Dijkstra

Directed Positive-weight Graph

**Remarks**
 - Dijkstra only need V-1 selection with several update regarding adjacent edges.
 - When using the priority queue, `continue` for already selected node by higher weight is necessary for speed!

example
```java
package javas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Comparator;

class Node {
	int to;
	int weight;
	public Node(int to, int weight){
		this.to = to;
		this.weight = weight;
	}
}

public class Main {
	
	static BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer ST;
	static BufferedWriter BW = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder ANSWER;
	static int V, E, s;
	static ArrayList<Node>[] graph = new ArrayList[20001];
	static int[] D = new int[20001];
	static final int INF = 98765432;
	static PriorityQueue<Node> Q = new PriorityQueue<Node>(1000000, new Comparator<Node>(){
		
		@Override
		public int compare(Node arg0, Node arg1) {
			if(arg0.weight < arg1.weight) return -1;
			else return 1;
		}
	});
	
	public static void main(String[] args) throws Exception {
		ST = new StringTokenizer(BR.readLine().trim());
		V = Integer.parseInt(ST.nextToken());
		E = Integer.parseInt(ST.nextToken());
		ANSWER = new StringBuilder();
		s = Integer.parseInt(BR.readLine().trim());
		
		for (int i = 1; i < V+1; i++){
			graph[i] = new ArrayList<Node>();
			D[i] = INF;
		}
		
		
		int u, v, w;
		for(int i =1; i < E+1; i++){
			ST = new StringTokenizer(BR.readLine().trim());
			u = Integer.parseInt(ST.nextToken());
			v = Integer.parseInt(ST.nextToken());
			w = Integer.parseInt(ST.nextToken());
			graph[u].add(new Node(v, w));
		}
		dijkstra(s);
		for(int i=1; i < V+1; i++){
			if(D[i] < INF) ANSWER.append(D[i]);
			else ANSWER.append("INF");
			ANSWER.append('\n');
		}
		BW.write(ANSWER.toString());
		BW.close();
		BR.close();
		
	}
	
	public static void dijkstra(int s){
		Q.clear();
		D[s] = 0;
		Q.offer(new Node(s, -1));	
		Node curNode;
		int iter = 0;	
		while(!Q.isEmpty()){
			curNode = Q.poll();
			
			if(D[curNode.to] < curNode.weight) continue;
			for(Node a: graph[curNode.to]){
				if(D[a.to] > D[curNode.to]+a.weight){
					D[a.to] = D[curNode.to]+a.weight; 
					Q.offer(new Node(a.to, D[a.to]));
				}
			}
			iter++;
			
			if(iter > V) break;
		}
		
	}
}

```


## II. BellmanFord
Directed Cycle.
Negative weight is allowable.
However, Negative Cycle is not allowed.

BellmanFord can detect Negative Cycle at the Nth iteration.


## III. Floyd-Warshall