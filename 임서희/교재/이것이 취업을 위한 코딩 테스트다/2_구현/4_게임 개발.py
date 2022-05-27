# 내코드
N, M = map(int,input().split())
x, y, c= map(int, input().split())
Map = []
for i in range(N):
    line = list(map(int,input().split()))
    Map.append(line)
    
dx=[0,1,0,-1]
dy=[-1,0,1,0]
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