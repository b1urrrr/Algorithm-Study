# 수학
# 14652번: 나는 행복합니다~
# 시간초과: 수학적으로 다시 생각해보기
n, m, k = map(int, input().split())
v = True
cnt = 0
for i in range(n):
    for j in range(m):
        if v and cnt == k:
            print(i, j)
            v = False
            break
        cnt += 1
    if v == False:
        break