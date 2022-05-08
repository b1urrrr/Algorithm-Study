# 백트래킹
# N-Queen 문제

# 백트래킹 vs 브루트포스 vs BFS,DFS 알고리즘 정리하기
# + 동적 계획법

# 퀸은 대각선이랑 같은 직선 상에 놓으면 안된다
def check(x):
    for i in range(x):
        if col[i] == col[x] or abs(col[i]-col[x]) == x-i:
            return False
    return True

n = int(input())
res = 0
col = [0] * 15

def dfs(x):
    global res
    if x == n:
        res += 1
        return
    for i in range(n):
        col[x] = i
        if check(x):
            dfs(x+1)

dfs(0)
print(res)
