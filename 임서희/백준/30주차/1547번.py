# 구현, 시뮬레이션
# 1547번: 공
n = int(input())
ball = [False, True, False, False]

for _ in range(n):
    a, b = map(int, input().split())
    ball[a], ball[b] = ball[b],ball[a]

for i in range(len(ball)):
    if ball[i]:
        print(i)