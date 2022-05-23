# 내가 푼 코드
N = int(input())
move = list(input().split())
x = y = 1

for m in move:
    if m == 'R':
        if (y+1) <= N:
            y += 1
    elif m == 'L':
        if (y-1) >= 1:
            y -= 1
    elif m == 'D':
        if (x+1) <= N:
            x+=1
    else:
        if (x-1) >= 1:
            x-=1
print(f'{x} {y}')

# 답안 예시
n = int(input())
x, y = 1, 1
plans = input().split()

# L R U D 이동 방향
dx = [0,0,-1,1]
dy = [-1,1,0,0]
move_types = ['L','R','U','D']

# 이동 계획 하나씩 확인
for plan in plans:
    # 이동 후 좌표 구하기
    for i in range(len(move_types)):
        if plan == move_types[i]:
            nx = x + dx[i]
            ny = y + dy[i]
    # 공간을 벗어나는 경우 무시
    if nx < 1 or ny < 1 or nx > n or ny > n:
        continue
    # 벗어나지 않는다면 이동 수행
    x, y = nx, ny
print(x, y)