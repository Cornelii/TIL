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
    d[r] <- 0
    
    WHILE (S != V)
    {
     	u <- extractMin(V-S,d)
     	S <- Set_Union(S, {u})
     	
     	FOR EACH v AMONG L(u)
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







