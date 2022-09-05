# 백트래킹
# 15663번: N과 M(9)
# 다시 생각해보기

# 자기 자신이 출력되는 상황을 어떻게 없앨 수 있을지 생각해보기
n, m = map(int, input().split())
n_list = sorted(list(map(int, input().split())))
n_list.append(0)
su = []
output= []

def dfs():
    if len(su) == m:
        #if 
        output.append(su)
        print(' '.join(map(str,su)))
        return
    for i in range(len(n_list)-1):
        if n_list[i] == n_list[i+1]:
            continue
        su.append(n_list[i])
        dfs()
        su.pop()
dfs()


# itertools.permutations(list,n) : list에서 n개를 뽑는 순열
from itertools import permutations

N, M = map(int, input().split())
numlist = list(map(int, input().split()))
case = sorted(set(permutations(numlist, M))) # 중복되는 순열을 set으로 제거

for i in case:
    for j in i:
        print(j, end=" ")
    print()