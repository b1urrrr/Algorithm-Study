# 재귀로 DFS 구현: Recursion Error 발생
def dfs(graph, r , visited):
    visited[r] = True
    print(r)
    for i in graph[r]:
        if not visited[i]:
            dfs(graph, i, visited)


n, m, r = map(int, input().split())
visited = [False] * (n+1)
graph = [[] for _ in range(n+1)] # 정점 개수만큼 그래프 2차원 배열 생성
for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

for i in range(1, n+1):
    graph[i].sort()

dfs(graph, r, visited)
print(0)

# 다른 사람 코드: 스택을 이용하여 DFS 구현 → 정답인데 1260번 예시는 다르게 나와서 다시 보기
from collections import deque

n, m, r = map(int, input().split())

nodes = [[] for _ in range(n+1)]
visited = [False for _ in range(n+1)]
nodes_cnt = [0 for _ in range(n+1)]
for _ in range(m):
    tail, head = map(int, input().split())
    nodes[tail].append(head)
    nodes[head].append(tail)

for i in range(n+1):
    nodes[i].sort(reverse=True) # 역순 정렬을 해야 스택에서 먼저 나가야 할 게 나중에 들어오기 때문
cnt = 1

stack = deque()
stack.append(r)

while stack:
    cur_node = stack.pop() # 뒤에 있는 노드 pop
    visited[cur_node] = True
    if nodes_cnt[cur_node] == 0:
        nodes_cnt[cur_node] = cnt # 어떤 순서로 출력 되는지 nodes_cnt 배열에 1번째 인덱스부터 입력
        cnt += 1

    for next_node in nodes[cur_node]:
        if not visited[next_node]:
            stack.append(next_node)


for cnt in nodes_cnt[1:]:
    print(cnt)

# 다른 사람 코드 수정 → 답은 나오는데 시간초과
from collections import deque

n, m, r = map(int, input().split())

nodes = [[] for _ in range(n+1)]
visited = [False for _ in range(n+1)]
nodes_cnt = [0 for _ in range(n+1)]
for _ in range(m):
    tail, head = map(int, input().split())
    nodes[tail].append(head)
    nodes[head].append(tail)

for i in range(1, n+1):
    nodes[i].sort(reverse=True)
print(nodes)
cnt = 1

stack = deque()
stack.append(r)

while stack:
    cur_node = stack.pop()
    print('cur_nod =' , cur_node)
    visited[cur_node] = True
    #print(nodes_cnt)
    #if nodes_cnt[cur_node] == 0:
    if cnt <= m and visited.count(True) == cnt:
        nodes_cnt[cnt] = cur_node
        cnt += 1

    for next_node in nodes[cur_node]:
        if not visited[next_node]:
            stack.append(next_node)

for cnt in nodes_cnt[1:]:
    print(cnt)

# 다시 풀어보기