n = int(input())

res = 0

for i in range(1, n+1):
    tmp = i + sum(map(int, str(i)))
    # 자릿수 더하는 방법
    # sum(map(int, str(number)))
    if tmp == n:
        res = i
        break

print(res)