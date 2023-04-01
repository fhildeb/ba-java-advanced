# Graph (Main)

This program implements two graph search methods: Depth-first search (DFS) and Breadth-first search (BFS). It represents the graph using a neighborhood list and supports loading graphs from files. The program also checks if the graph is connected or disconnected. The depth-first search algorithm is extended to work with symbol graphs, such as airport routes or film-actor connections. Finally, the program implements a breadth-first search method for the given graphs.

## Terminal Output

Parameter: `graph1.txt`

```bash
6 vertices, 8 edges
0: 5 1 2
1: 2 0
2: 4 3 1 0
3: 2 4 5
4: 2 3
5: 0 3
```

Parameter: `graph2.txt`

```bash
13 vertices, 13 edges
0: 5 1 2 6
1: 0
2: 0
3: 4 5
4: 3 6 5
5: 0 4 3
6: 4 0
7: 8
8: 7
9: 12 10 11
10: 9
11: 12 9
12: 9 11
```
