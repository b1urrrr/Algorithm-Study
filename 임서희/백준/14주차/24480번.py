# 알고리즘 수업 - 깊이 우선 탐색 2
# 깊이 우선 탐색 1은 오름차순이었기 때문에 그와 반대로 정렬해서 넣으면 됨
# 그래도 너무 오래 걸리는 편
from collections import deque
import sys # 시간 초과나서 sys 임포트해서 input을 아래처럼 받기

n, m, r = map(int, sys.stdin.readline().split())

nodes = [[] for _ in range(n+1)]
visited = [False for _ in range(n+1)]
nodes_cnt = [0 for _ in range(n+1)]
for _ in range(m):
    tail, head = map(int, sys.stdin.readline().split())
    nodes[tail].append(head)
    nodes[head].append(tail)

for i in range(n+1):
    nodes[i].sort() # 내림차순
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

# 다른 사람 코드: 시간 778ms
# dfs

import sys
from collections import defaultdict

input = sys.stdin.readline
sys.setrecursionlimit(10 ** 6)

N, M, s = list(map(int, input().split()))
connected = defaultdict(list)
for _ in range(M):
    p1, p2 = list(map(int, input().split()))
    connected[p1].append(p2)
    connected[p2].append(p1)

for i in connected.keys():
    connected[i].sort(reverse=True)

visited = [False for _ in range(N + 1)]
visited[s] = True
ans = defaultdict(int)
count = 1
ans[s] = count
count += 1

def dfs(cur_point):
    global count
    for i in connected[cur_point]:
        if not visited[i]:
            visited[i] = True
            ans[i] = count
            count += 1
            dfs(i)

dfs(s)
for i in range(1, N + 1):
    print(ans[i])