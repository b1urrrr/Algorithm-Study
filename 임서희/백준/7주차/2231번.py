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