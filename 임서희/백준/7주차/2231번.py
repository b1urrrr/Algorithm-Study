# 맞는 내 코드: 1200ms
N = int(input())
min_result = N

for i in range(N, 1, -1):
    b = i
    sum = i
    while b > 0:
        sum = sum + (b%10)
        b = b//10
    if sum == N and min_result >= i:
        min_result = i

if min_result != N:
    print(min_result)
else:
    print(0)


# 다른 방법: 1916ms
n = int(input())
f = []

for i in range(n):
    count = 0
    for i2 in list(str(i)):
        count += int(i2)
    if n == i+count:
        f.append(i)
if len(f) == 0:
    print(0)
else:            
    print(min(f))