import math
t = int(input())

for _ in range(t):
    x1, y1, r1, x2, y2, r2 = map(int, input().split()) 
    distance = math.sqrt((x1 - x2) ** 2 + (y1 - y2) ** 2) # 두 원의 중심 사이의 거리
    if (distance == 0):
        if (r1 == r2): # 두 원이 일치할 때
            print(-1) 
        else: # 원 안에 원이 있을 때
            print(0)
    elif (abs(r1-r2) == distance or r1 + r2 == distance):
        print(1)
    elif (abs(r1-r2) < distance < (r1 + r2)):
        print(2)
    else:
        print(0)
