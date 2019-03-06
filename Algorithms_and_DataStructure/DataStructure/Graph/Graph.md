# Graph

$$
G = (V,E)
$$

**vertex and edges!**

or G = {V, E} depending on directed / undirected



## I. Classification

1. Directed / Undirected
2. Loops
3. Multiple ?!
4. Weighted ?!



## II. Expressive way for Graphs

#### 1. Adjacent Matrix

$$
E_{ij} = M[i][j]
$$

* Positive: Easy to check existence of edge between vertices
* Negative: N x N matrix is needed. Moreover, Constructing Adjacent Matrix itself has time complexity of O(n^2)
* **The denser edges, the better adjacent matrix.**



#### 2. Adjacent List

**by Linked List**.

Each node has <vertex point, weight, point to next vertex>.

* **The sparser edges, the better adjacent list.**



## III. Searching Ways

#### 1. BFS (Breadth-First Search)

```
BFS(G, s)
{
    visited[s] <- True  // s: starting point
    enqueue(Q, s) // Q: Queue
    
    WHILE (Q != empty_set)
    {
    	u <- dequeue(Q)
        FOR EACH v AMONG L(u) // L(u): adjacent list of u
        	IF(visited[v] == False)
        	{
                visited[v] <- True
                enqueue(Q, v)
        	}
    }
}
```




#### 2. DFS(Depth-First Search)

```
DFS(s)
{
	visited[s] <- True
    FOR EACH v AMONG L(s)
    	IF(visited[v]==False)
    		DFS(v)
}
```



## IV. Minimum Spanning Tree

Spanning Tree is thing that only leaves **|V|-1 edges at the G=(V, E) preserving vertices V.**

Minimum Spanning Tree is Spanning Tree of Weighted G=(V,E) that has minimum weight value in total.

#### 1. Prim Algorithm

It starts from empty `set S` growing `S` until this set reaches `V`.

```
Prim(G, r) // G: graph(V,E), r: starting node
{
    S <-empty set
    // d set by infinity?! so large number initially
    d[r] <- 0
    
    WHILE (S != V)
    {
     	u <- extractMin(V-S,d)
     	S <- Set_Union(S, {u})
     	
     	FOR EACH v AMONG L(u) // L(u) set of adjacent nodes of u
     		if (v AMONG V-S and w(u, v)<d[v])
     		{
                d[v] <- w(u,v)
                tree[v] <- u
     		}
    }
}

extractMin(Q, d[])
{
    return {node u that has minimum d in set Q}
}
```



Other PseudoCode ( Q (V) -> empty set)

```
Prim(G, r)
{
    Q <- V   // Q: set of nodes that does not belong to S
    
    d[r] <- 0 // entries in D corresponding node of V is set by large number initially.
    WHILE Q != empty set
    {
        u <- deleteMin(Q, d)
        FOR EACH v AMONG L(u)
        	IF v belongs to Q and w(u, v) < d[v]
        	{
                d[v] <- w(u, v)
                tree[v] <- u
        	}
        
    }
}

deleteMin(Q, d[]){
    From set Q, this function return u that has minimum value in d removing u in Q.
}
```



#### 2. Kruskal Algorithm

This does not start from a tree(a node), but, N node scattered!



```
Kruskal(G)
{
    T <- empty set
    init # of N sets where each has a tree (a node) (N1, N2, and so on.)
    A <- all the edge in ascending order with respect to its weight.
    
    WHILE (E of T's edge < n-1)
    {
        remove minimum (u, v) from A
        if (u and v are not in the same Set(N1, N2, and so on.) )
        {
            T <- Set_Union(T,{u,v})
            Set_Union(N_of_u, N_of_v) // this means u and v are in the same set.
        }
    }
    
}
```



## V. Topological Sorting

Sorting V in Directed G(E, V), but for (i, j)s ith Node should come before jth Node : Topological Sorting



```
topologicalSort1(G)
{
    FOR <- 1 to n
    {
    	choose u that does not have edge to come in
        A[i] <- u
        remove u and edges, which is to go out, of u 
    }
    A[1..n] => topologically sorted nodes
    
}
```



Using DFS

```
topologicalSort2(G)
{
	init visited with NO
	FOR EACH v AMONG V (Order does not matter.)
		IF (visited[v] = No)
			DFS_TS(v)
}

DFS-TS(v)
{
    visited[v] = YES;
    FOR EACH w AMONG L(v)
    	IF(visited[w] = No)
    		DFS-TS
    insert v at front of linked list.
}

```





## VI. Shortest Path

1. Dijkstra Algorithm : for non-negative weights.
2. Bellman-Ford Algorithm: available for negative weights but, it does not allows cycles with negative weight sum on the path.
3. Etc



#### 1. Dijkstra Algorithm

For graph with non-negative weights.

```
Dijkstra(G, r) // G=(V, E) // r= starting node
{
    S <- empty set
    init d[] with infinity
    d[r] <- 0
    
    WHILE(S != V)
    {
        u <- extraMin(V-S, d)
        S <- Set_Union(S, u)
        FOR EACH v AMONG L(u)
        	IF( v belongs to V-S and d[u]+w(u, v) <d[v])
        		d[v] <- d[u] + w(u, v)
        		prev[v] <- u
    }
}

extractMin(Q, d[])
{
    return u that has minimum d value in set Q
}
```





#### 2.Bellman-Ford Algorithm

This is available for negative weights but, it does not allows cycles with negative weight sum on the path.

```
BellmanFord(G, r)
{
    init d[] with inifinity
    d[r] <- 0
    
    FOR i <- 1 to |V|-1
    	FOR EACH (u, v) AMONG E
    		IF (d[u] + w(u, v) < d[v])
    			d[v] <- d[u] + w(u,v)
    			prev[v] <- u
    			
    // check existence of negative cycle
    FOR EACH(u, v) AMONG E
    	IF(d[u] + w(u, v) < d[v])
    		OUTPUT "NO SOLUTION"
}
```



#### 3. Every pairs shortest path



#### 4. Floyd-Warshall algorithm



#### 5. DAG algorithm(directed acyclic graph)

