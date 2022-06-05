# 큐
# 요세푸스 문제
from collections import deque

n, k = map(int, input().split())
q = deque([x for x in range(1,n+1)])
answer = []

while q: # q가 true일 때까지, 다시 말해 안에 무언가 있을 때까지
    for i in range(k-1): # k-1만큼 빼서 뒤로 보내기(뒤에 다시 붙이기)
        q.append(q.popleft())
    answer.append(q.popleft()) # k번째로 빠져야 하는 건 빼면서 answer에 추가

print('<', end='')
for i in range(len(answer)-1):
    print(answer[i], end=', ')
print(answer[-1], end='')
print('>')