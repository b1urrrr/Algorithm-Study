# 백트래킹
# 15650번: N과 M(2)
n,m = map(int, input().split())
su = []
def dfs(start):
    if len(su) == m:
        print(' '.join(map(str,su)))
        return
    for i in range(start,n+1):
        if i not in su:
            su.append(i)
            dfs(i+1) # 자기 자신의 다음꺼가 들어가야 함
            su.pop()
dfs(1)

