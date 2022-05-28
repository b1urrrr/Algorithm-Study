# 내코드: 안돌아간다
N, M = map(int,input().split())
x, y, c= map(int, input().split())
Map = []
for i in range(N):
    line = list(map(int,input().split()))
    Map.append(line)
    
dx=[-1,0,1,0]
dy=[0,1,0,-1]
cnt = 0

while True:
    if Map[x][y] == 0:
        cnt += 1
        Map[x][y] = 2 # 방문한건 2로 표시
    for _ in range(4):
        c = (c+3)%4
        nx = x + dx[c]
        ny = y + dy[c]
        if Map[nx][ny] == 0:
            break
    else:
        k = (c+2)%4 # 방향 유지하고 뒤로 이동
        nx = x + dx[k]
        ny = y + dy[k]
        if Map[nx][ny] == 1: # 뒤에가 바다면 움직임 멈추기
            break
print(cnt)

# 답안
# 다시 풀기
n, m = map(int,input().split())
d = [[0]*m for _ in range(n)] # 방문한 위치 저장
x, y , direction = map(int,input().split())
d[x][y] = 1 # 현재 좌표 방문 처리

array = [] # 전체 맵
for i in range(n):
    array.append(list(map(int,input().split()))) # 한 줄씩 입력 추가

# 북, 동, 남, 서
# x좌표가 북쪽에서 떨어진 것, y좌표가 서쪽에서 떨어진 것
dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

# 왼쪽으로 회전
def turn_left():
    global direction
    direction -= 1
    if direction == -1:
        direction = 3
        
count = 1
turn_time = 0

# 시뮬레이션 시작
while True:
    turn_left() # 우선 왼쪽으로 회전
    nx = x + dx[direction]
    ny = y + dy[direction]
    # 왼쪽으로 회전한 이후, 정면에 가보지 않는 칸이 있는 경우
    # 즉, d리스트가 0이면 방문하지 않은 것이고, array도 0이면 육지이므로 방문 가능
    if d[nx][ny] == 0 and array[nx][ny] == 0:
        d[nx][ny] = 1 # 방문했음으로 체크
        x = nx
        y = ny
        count += 1
        turn_time = 0
        continue
    # 회전은 했는데 정면에 가보지 않은 칸이 없거나 바다인 경우
    else:
        turn_time += 1 # 4가 아닐 때까지 while문으로 왼쪽 방향으로 돌고 다시 체크
    if turn_time == 4: # 4번 회전. 즉, 네 방향 모두 갈 수 없는 경우
        nx = x - dx[direction]
        ny = y - dy[direction]
        # 뒤로 이동. 단, 뒤에가 육지여야만 이동 가능
        if array[nx][ny] == 0:
            x = nx
            y = ny
        else: # 뒤가 바다인 경우
            break # 움직임 멈춤
        turn_time = 0
    
print(count)