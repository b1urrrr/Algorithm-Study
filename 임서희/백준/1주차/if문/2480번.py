a, b, c = map(int, input('').split())
money = 0

if a == b:
    if b == c:
        money = 10000 + a*1000
    else:
        money = 1000 + a*100
elif b == c:
    if a == b:
        money = 10000 + a*1000
    else:
        money = 1000 + b*100
elif a == c:
    if a == b:
        money = 10000 + a*1000
    else:
        money = 1000 + a*100
else:
    money = max(a, b, c)*100

print(money)
