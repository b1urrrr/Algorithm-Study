# 그리디 알고리즘
# 5585번: 거스름돈
n = int(input())
moneys = [500, 100, 50, 10, 5, 1]
n = 1000 - n
res = 0
for money in moneys:
    if n >= money:
        res += n//money
        n = n%money
print(res)