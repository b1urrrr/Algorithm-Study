# 백트래킹
# 15652번: N과 M(4)
n, m = map(int, input().split())
su = []

def dfs(i):
    if len(su) == m:
        print(' '.join(map(str,su)))
        return
    for i in range(i, n+1):
        su.append(i)
        dfs(i)
        su.pop()
dfs(1)

# 이전 코드
N, M = map(int, input().split())
s = []

def dfs(start):
    if len(s) == M:
        print(' '.join(map(str,s)))
        return
    for i in range(1, N+1):
        if len(s) != 0:
            if i >= s[len(s)-1]:
                s.append(i)
                dfs(i)
                s.pop()
        else:
            s.append(i)
            dfs(i)
            s.pop()
        
dfs(1)