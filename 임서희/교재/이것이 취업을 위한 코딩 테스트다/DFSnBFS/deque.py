# 큐 : First In First Out
from collections import deque

queue = deque() # 큐 구현을 위한 deque 라이브러리 사용

queue.append(5)
queue.append(2)
queue.append(3)
queue.append(7)
queue.popleft() # 5 pop (먼저 들어왔던거 pop)
queue.append(1)
queue.append(4)
queue.popleft() # 2 pop

print(queue) # deque([3,7,1,4])
queue.reverse() # 다음 출력을 위해 역순으로 바꾸기
print(queue) # deque([4,1,7,3])