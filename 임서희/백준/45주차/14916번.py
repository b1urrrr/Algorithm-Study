# 그리디 알고리즘, 수학, 다이나믹 프로그래밍
# 14916번: 거스름돈
n = int(input())
res = 0
if n < 5:
    if n%2 != 0:
        print(-1)
    else:
        print(n//2)
else:
    res += (n//5)
    n %= 5
    if n % 2 != 0:
        n += 5
        res -= 1
    if n % 2 != 0:
        print(-1)
    else:
        print(res + n//2)

