# 24444번: 알고리즘 수업 - 너비 우선 탐색 1
# 16주차 다른 코드
from collections import deque
import sys
input = sys.stdin.readline
queue = deque()


def bfs(V, E, R):
    V[R][0] = True
    V[R][1] = 1
    order = 1
    queue.append(E[R])

    while queue:
        u = queue.popleft()
        u.sort()
        for edge in u:
            if not V[edge][0]:
                order = order + 1
                V[edge][0] = True
                V[edge][1] = order
                queue.append(E[edge])

    for i in range(1, len(V)):
        print(V[i][1])


N, M, R = map(int, input().split())
E = [[] for _ in range(N + 1)]
V = [[False, 0] for _ in range(N + 1)]
for i in range(1, M + 1):
    u, v = map(int, input().split())
    E[u].append(v)
    E[v].append(u)

bfs(V, E, R)