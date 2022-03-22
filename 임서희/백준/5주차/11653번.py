# 내 코드: 성공(시간 1465ms)
# 파이썬은 시간이 오래 걸리는듯
N = int(input())
i = 2
while N > 1:
    if N%i == 0:
        N = N//i
        print(i)
    else:
        i += 1