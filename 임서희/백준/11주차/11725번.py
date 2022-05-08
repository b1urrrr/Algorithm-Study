# 트리
# 트리의 부모 찾기

# 내 코드: 답은 나오는데 시간 초과
N = int(input())
tree = [[] for i in range(N+1)]

for _ in range(N-1):
    a,b = map(int,input().split())
    tree[a].append(b)
    tree[b].append(a)

visited = [1]
parent = [0] * (N+1)
def dfs(p, t):
    for i in range(len(t)):
        if t[i] in visited:
            parent[p] = tree[p][0]
        else:
            visited.append(t[i])
            dfs(t[i],tree[t[i]])
            
dfs(1, tree[1])

for i in range(2, len(parent)):
    print(parent[i])

# 맞는 코드
import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**6)

n = int(input())
tree = [[] for _ in range(n+1)]
par = [0]*(n+1)
for _ in range(n-1):
    a,b = map(int,input().split())
    tree[a].append(b)
    tree[b].append(a)

def dfs(n):
    for i in tree[n]:
        if par[i] == 0:
            par[i] = n
            dfs(i)
            
dfs(1)
for i in range(2,n+1):
    print(par[i])