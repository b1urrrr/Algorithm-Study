# 백트래킹
# 15663번: N과 M(9)
# 다시 생각해보기

# 자기 자신이 출력되는 상황을 어떻게 없앨 수 있을지 생각해보기
n, m = map(int, input().split())
n_list = sorted(list(map(int, input().split())))
n_list.append(0)
su = []

def dfs():
    if len(su) == m:
        #if 
        print(' '.join(map(str,su)))
        return
    for i in range(len(n_list)-1):
        if n_list[i] == n_list[i+1]:
            continue
        su.append(n_list[i])
        dfs()
        su.pop()
dfs()