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

**Remarks**
 - To check out exactly negative cycle, when comparing,  `D[curNode.from]!=INF ` is necessary!

java example
```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

class P4 {
	int from, to, weight;
	public P4(int from, int to, int weight){
		this.from = from;
		this.to = to;
		this.weight = weight;
	}
}

public class BellmanFord {
	
	static BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter BW = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer ST;
	static StringBuilder ANSWER;
	static int N, M;
	static ArrayList<P4> Edges;
	static int[] D = new int[1000];
	static final int INF = 89765432;
	static boolean NC = false;
	
	public static void main(String[] args) throws Exception {
		ST = new StringTokenizer(BR.readLine().trim());
		N = Integer.parseInt(ST.nextToken());
		M = Integer.parseInt(ST.nextToken());
		Edges = new ArrayList<P4>();
		int a, b, c;
		for(int i = 0; i < M; i++){
			ST = new StringTokenizer(BR.readLine().trim());
			a = Integer.parseInt(ST.nextToken());
			b = Integer.parseInt(ST.nextToken());
			c = Integer.parseInt(ST.nextToken());
			Edges.add(new P4(a, b, c));
		}
		ANSWER = new StringBuilder();
		BellmanFord(1);
		
		if(!NC){
			for(int i = 2; i < N+1; i++){
				if(D[i] == INF) ANSWER.append(-1);
				else ANSWER.append(D[i]);
				ANSWER.append('\n');
			}
		}else
			ANSWER.append(-1).append('\n');
		BW.write(ANSWER.toString());
		
		BW.close();
		BR.close();
	}
	
	public static void BellmanFord(int s){
		int iter = 0;
		for(int i = 1; i < N+1; i++) D[i] = INF;
		D[s] = 0;

		while(iter < N - 1){
			for(P4 curNode: Edges){
				if(D[curNode.from]!=INF && D[curNode.to] > D[curNode.from]+curNode.weight){
					D[curNode.to] = D[curNode.from] + curNode.weight;
				}
			}
			iter++;
		}
		// Nth iteration to detect Negative Cycle
		for(P4 curNode: Edges){
			if(D[curNode.from]!=INF && D[curNode.to] > D[curNode.from]+curNode.weight){
				NC = true;
				break;
			}
		}
	}
}

```


## III. Floyd-Warshall

Shortest Path between all pair!

**Remarks** Bypass node should be most up side on for loops!

```cpp
#include <iostream>
using namespace std;

#define MAX_N 101

int N, M, d[MAX_N][MAX_N];
const int INF = 89765432;

int main() {
	ios_base::sync_with_stdio(0); cin.tie(0);
	cin >> N; cin >> M;
	int a, b, w;

	for (int i = 1; i < N + 1; i++) {
		for (int j = 1; j < N + 1; j++) {
			d[i][j] = INF;
		}
	}

	for (int i = 0; i < M; i++) {
		cin >> a >> b >> w;
		if (w < d[a][b])
			d[a][b] = w;
	}

	//Floyd-Warshall
	for (int k = 1; k < N + 1; k++) {
		for (int i = 1; i < N + 1; i++) {
			if (k == i) continue;
			for (int j = 1; j < N + 1; j++) {
				if (i == j || k == j) continue;
				if (d[i][j] > d[i][k] + d[k][j]) d[i][j] = d[i][k] + d[k][j];
			}
		}
	}

	for (int i = 1; i < N + 1; i++) {
		for (int j = 1; j < N + 1; j++) {
			if (d[i][j] != INF) printf("%d ", d[i][j]);
			else printf("0 ");
		}
		printf("\n");
	}

	return 0;
}
```

