# 그리디 알고리즘
# 2720번: 세탁소 사장 동혁
t = int(input())
coins = [25, 10, 5, 1]
for _ in range(t):
    n = int(input())
    for coin in coins:
        print(n//coin, end=' ')
        n %= coin
    print()