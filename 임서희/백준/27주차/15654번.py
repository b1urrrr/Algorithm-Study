# 백트래킹
# 15654번: N과 M(5)

# 백트래킹이 잘 기억 안나서 N과 M(1)~(4) 다시 복습

# 복습 후 문제 풀이
# N과 M(1) 참고
n, m = map(int, input().split())
n_list = list(map(int, input().split()))
n_list = sorted(n_list)
su = []

def dfs():
    if len(su) == m:
        print(' '.join(map(str,su)))
        return
    for i in n_list:
        if i not in su:
            su.append(i)
            dfs()
            su.pop()
dfs()