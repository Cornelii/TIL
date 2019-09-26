# Prim algorithm for minimum spaning Tree
n, m = list(map(int, input().split())) # # of nodes // vertices

graph = [[0]*n for _ in range(n)]
visit_table = [1]*n
max_w = 0

for _ in range(m):
    i, j, w = list(map(int, input().split()))
    graph[i - 1][j - 1] = w
    graph[j - 1][i - 1] = w # undirected graph
    if max_w < w:
        max_w = w

d = [max_w+1]*n # cost table

##### implementation of Prim algorithm without Queue
# <No Queue, Adjacent Matrix>\

def prim(graph, n, visit_table,r): # r => starting node_index!! node_number -1
    tree = [None]*n
    d[r] = 0
    while any(visit_table):
        u = extractMin(n, visit_table)
        visit_table[u] = 0
        for i in range(n):
            if graph[u][i] and visit_table[i] and graph[u][i] < d[i]:
                d[i] = graph[u][i]
                tree[i] = u
    return tree

def extractMin(n, visit_table):
    min_idx = max_w+1
    idx = None
    for i in range(n):
        if visit_table[i]:
            val = d[i]
            if min_idx > val:
                min_idx = val
                idx = i
    return idx


MST = prim(graph, n, visit_table, 0)
print(MST)

