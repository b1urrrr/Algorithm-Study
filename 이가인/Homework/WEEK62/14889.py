n = int(input())
s = [list(map(int, input().split())) for _ in range(n)]

visited = [0 for _ in range(n)]
res = 2147000000

def DFS(L, idx):
    global res
    if L == n // 2:
        A = 0
        B = 0
        for i in range(n):
            for j in range(n):
                if visited[i] and visited[j]:
                    A += s[i][j]
                elif not visited[i] and not visited[j]:
                    B += s[i][j]
        res = min(res, abs(A - B))
    for i in range(idx, n):
        if not visited[i]:
            visited[i] = 1
            DFS(L + 1, i + 1)
            visited[i] = 0

DFS(0, 0)
print(res)