# BOJ 10026 적록색약 - 골드 5

n = int(input())
board = [list(input()) for _ in range(n)]
visited = [[False] * n for _ in range(n)]
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
cnt1, cnt2 = 0, 0

def dfs(x, y, cnt):
    visited[x][y] = True
    current = board[x][y]
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= nx < n and 0 <= ny < n and not visited[nx][ny] and board[nx][ny] == current:
            dfs(nx, ny, cnt)

for i in range(n):
    for j in range(n):
        if not visited[i][j]:
            dfs(i, j, cnt1)
            cnt1 += 1

for i in range(n):
    for j in range(n):
        if board[i][j] == 'G':
            board[i][j] = 'R'

visited = [[False] * n for _ in range(n)]

for i in range(n):
    for j in range(n):
        if not visited[i][j]:
            dfs(i, j, cnt2)
            cnt2 += 1

print(cnt1, cnt2)

