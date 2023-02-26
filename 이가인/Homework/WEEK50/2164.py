from collections import deque
n = int(input())

nums = []
deque = deque([i for i in range(1, n+1)])

while(len(deque) > 1):
    deque.popleft()
    move = deque.popleft()
    deque.append(move)
    
print(deque[0])