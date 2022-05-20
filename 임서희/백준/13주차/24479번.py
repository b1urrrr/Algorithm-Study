def dfs(graph, r , visited):
    visited[r] = True
    print(r)
    for i in graph[r]:
        if not visited[i]:
            dfs(graph, i, visited)


n, m, r = map(int, input().split())
visited = [False] * n
graph = [[] for _ in range(n+1)] # 정점 개수만큼 그래프 2차원 배열 생성
for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

for i in range(n+1):
    graph[i].sort()

dfs(graph, r, visited)
