# 백트래킹
# 15651번: N과 M(3)

n, m = map(int, input().split())
su = []

def dfs():
    if len(su) == m:
        print(' '.join(map(str,su)))
        return
    for i in range(1, n+1):
        su.append(i)
        dfs()
        su.pop()

dfs()

# 이전 코드
# 굳이 start를 넘기지 않아도 된다!
N, M = map(int, input().split())
s = []

def dfs(start):
    if len(s) == M:
        print(' '.join(map(str,s)))
        return
    for i in range(1, N+1):
        s.append(i)
        dfs(i)
        s.pop()
dfs(1)