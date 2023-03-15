# 그리디 알고리즘, 너비 우선 탐색
# 16953번: A → B

# 푸는 중
# 코드 참고: https://my-coding-notes.tistory.com/210
# BFS 이용하기
from collections import deque
a,b = map(int,input().split())
q = deque()
q.append((a,1))
r = 0

while(q):
    n,t = q.popleft()
    if n > b:
        continue
    if n == b:
        print(t)
        break
    q.append((int(str(n)+"1"),t+1))
    q.append((n*2,t+1))
else:
    print(-1)