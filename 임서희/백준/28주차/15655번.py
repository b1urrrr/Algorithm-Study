# 백트래킹
# 15655번: N과 M(5)
n, m = map(int, input().split())
n_list = list(map(int, input().split()))
n_list = sorted(n_list)
su = []

def dfs(start):
    if len(su) == m:
        print(' '.join(map(str,su)))
        return
    for i in range(start, n):
        if n_list[i] not in su:
            su.append(n_list[i])
            dfs(i+1)
            su.pop()
dfs(0)