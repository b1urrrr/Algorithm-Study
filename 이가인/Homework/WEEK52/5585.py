# 5585
# 그리디 알고리즘
n = int(input())

res = 1000 - n

cnt = 0

coin = [500, 100, 50, 10, 5, 1]

for i in coin:
    cnt += res // i
    res %= i

print(cnt)