r, c, k = map(int, input().split())
board = [list(input()) for _ in range(r)]
dx=[-1,1,0,0]
dy=[0,0,-1,1]
answer = 0

def dfs(x, y, cnt):
    global answer
    if cnt == k and (x, y) == (0, c-1):
        answer += 1
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= nx < r and 0 <= ny < c and board[nx][ny] == '.':
            board[nx][ny] = 'T'
            dfs(nx, ny, cnt+1)
            board[nx][ny] = '.'

board[r-1][0] = 'T'
dfs(r-1, 0, 1)
print(answer)