# 큐
# 카드2
from collections import deque

N = int(input())
q = deque()
# queue = deque([x for x in range(1,N+1)])

for i in range(1,N+1):
    q.append(i)

while len(q) != 1:
    a = q.popleft()
    b = q.popleft()
    q.append(b)

print(q[0])