N = int(input())
a = N
min_result = a

while a > 0:
    b = a
    sum = a
    result = a
    while b > 0:
        sum = sum + (b%10)
        b = b // 10
    if sum == N and min_result > result:
        min_result = result
    else:
        a -= 1
if min_result == a:
    print(0)
else:
    print(min_result)