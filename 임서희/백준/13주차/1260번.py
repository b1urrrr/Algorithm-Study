from collections import deque

def dfs(graph, v, d_visited):
	# 현재 노드를 방문 처리
	d_visited[v] = True
	print(v, end= ' ')
	# 현재 노드와 연결된 다른 정보를 재귀적으로 방문
	for i in graph[v]:
		if not d_visited[i]:
			dfs(graph, i ,d_visited)


def bfs(graph, start, b_visited):
	# 큐 구현을 위해 deque 라이브러리 사용
	queue = deque([start])
	# 현재 노드 방문 처리
	b_visited[start] = True
	# 큐가 빌 때까지 반복
	while queue:
		# 큐에서 하나의 원소를 뽑아 출력4 5
		v = queue.popleft()
		print(v, end=' ' )
		# 해당 원소와 연결되고 아직 방문하지 않은 원소들을 큐에 삽입
		for i in graph[v]:
			if not b_visited[i]:
				queue.append(i)
				b_visited[i] = True

N, M, V= map(int, input().split())
graph = [[] for _ in range(N+1)]
d_visited = [False] * (N+1)
b_visited = [False] * (N+1)
for _ in range(M):
    a,b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

for i in range(1, N+1): # 2차원 배열 내부 정렬
    graph[i].sort()

dfs(graph, V, d_visited)
print()
bfs(graph, V ,b_visited)