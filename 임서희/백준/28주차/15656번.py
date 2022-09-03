# 백트래킹
# 15656번: N과 M(7)
n, m = map(int, input().split())
n_list = sorted(list(map(int, input().split())))
su = []

def dfs(start):
    if len(su) == m:
        print(' '.join(map(str,su)))
        return
    for i in range(len(n_list)):
        su.append(n_list[i])
        dfs(i)
        su.pop()
dfs(0)