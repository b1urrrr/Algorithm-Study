# DFS 메서드 정의
# 스택을 이용(재귀 함수로 구현)

def dfs(graph, v, visited):
	# 현재 노드를 방문 처리
	visited[v] = True
	print(v, end= ' ')
	# 현재 노드와 연결된 다른 정보를 재귀적으로 방문
	for i in graph[v]:
		if not visited[i]:
			dfs(graph, i ,visited)