# 수학
# 10156번: 과자
k, n, m = map(int, input().split())
res = k*n - m
if res >= 0:
    print(res)
else:
    print(0)