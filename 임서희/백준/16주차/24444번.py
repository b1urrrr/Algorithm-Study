# 그래프와 순회
# 24444번: 알고리즘 수업 - 너비 우선 탐색1

# 책대로 했는데 0 출력이 없음
# 틀린 내 코드
from collections import deque
def bfs(graph, v, visited):
    queue = deque([v])
    visited[v] = True
    while queue:
        n = queue.popleft()
        print(n)
        for i in graph[n]:
            if not visited[i]:
                queue.append(i)
                visited[i] = True
n, m, v = map(int, input().split())
graph = [[] for i in range(n+1)]
visited = [False] * (n+1)
for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)
for i in range(n+1):
    graph[i].sort()
if len(graph[v]) != 0:
    bfs(graph, v, visited)
    if False in visited:
        print(0)
else:
    print(0)


# 다른 사람 코드
from collections import deque

N,M,R = map(int,input().split())

# graph
graph=[[] for _ in range(N+1)]

#입력받는 간선 정보 그래프화
for i in range(M):
    tmpL=list(map(int,input().split()))
    graph[tmpL[0]].append(tmpL[1])
    graph[tmpL[1]].append(tmpL[0])

# 정렬
for i in range(N+1):
    graph[i].sort()

#BFS 함수 
def bfs(graph,R,visited):
    queue=deque([R])
    visited[R]=1 #첫번째 방문 정점
    count=2 #두번째 방문 정점
    
    while queue:
        R=queue.popleft()
        
        for i in graph[R]:
            if visited[i]==0:
                queue.append(i)
                visited[i]=count 
                count+=1 # n+1 번째 방문 정점

#정점 리스트
visited=[0]*(N+1)

bfs(graph,R,visited)

#출력
for i in visited[1::]:
    print(i)


# dfs, bfs 코드 다른 방식으로 구현한거 다시 살펴보기