# 틀린 내 코드
N = int(input()) # 노드의 개수
tree = [0] * (N+1)
tree[1] = 1

for i in range(N-1):
    a,b = map(int, input().split())
    if tree[a] != 0:
        tree[b] = a
    elif tree[b] != 0:
        tree[a] = b
        
for i in range(2,N+1):
    print(tree[i])

# 트리의 부모 찾기는 DFS, BFS를 활용하여서 검색한다.
# 트리를 리스트로 구현할 때는 이중 리스트로, 부모와 자식 노드에 서로를 표현한다.
import sys
input = sys.stdin.readline
# 런타임 에러(Recursion Error) 방지를 위해 아래와 같이 표현한다.
# 재귀와 관련된 에러로 파이썬이 정한 최대 재귀 깊이보다 더 깊어질 때 발생한다.
# sys.setrecurtionlimit()로 최대 재귀 깊이를 변경할 수 있다.
# 최대 재귀 깊이가 1000으로 설정되어 에러가 발생할 수 있으니 최대 N의 값으로 변경한다.
sys.setrecursionlimit(10**6) 

n = int(input())
tree = [[] for _ in range(n+1)]
par = [-1]*(n+1)
for _ in range(n-1):
    a,b = map(int,input().split())
    tree[a].append(b)
    tree[b].append(a)

def dfs(n):
    for i in tree[n]: # 관련된 노드를 꺼내온다
        if par[i] == -1: # -1이라면 부모 노드가 아직 설정이 안된 것
            par[i] = n
            dfs(i)
            
dfs(1)
for i in range(2,n+1):
    print(par[i])