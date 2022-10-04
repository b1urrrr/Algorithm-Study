from collections import deque
N = int(input())
K = int(input())
apple = []
for _ in range(K):
    r, c = map(int, input().split())
    apple.append((r-1, c-1))
L = int(input())
dir = {}
for _ in range(L):
    t, spin = map(str, input().split())
    dir[int(t)] =spin
d = [[-1,0], [0,1], [1,0], [0,-1]]
time = 0
curD = 1
curR = 0
curC = 0
answer = 0
map = [[0]*N for _ in range(N)]
map[0][0] = 1
next_dir = {'D': 1, 'L': -1}
snake = deque()
snake.append((0,0))

while(True):
    # 앞으로 이동
    nr = curR+d[curD][0]
    nc = curC+d[curD][1]
    time += 1
    if nr<0 or nr>=N or nc<0 or nc>=N or map[nr][nc] == 1:
        answer = time
        break;
    map[nr][nc] = 1# 머리 이동
    snake.append((nr, nc))
    # 사과 존재여부
    if (nr, nc) in apple:
       apple.remove((nr, nc))
    else:
        tail = snake.popleft()
        map[tail[0]][tail[1]] = 0
    # 다음 방향
    if time in dir:
        curD += next_dir[dir[time]]
    if curD<0:
        curD=3
    elif curD>3:
        curD=0
    curR = nr
    curC = nc
print(answer)