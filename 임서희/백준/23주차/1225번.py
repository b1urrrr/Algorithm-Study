# 문자열
# 1225번: 이상한 곱셈
# 시간 초과
n, m = map(str, input().split())

res = 0
for i in n:
    for j in m:
        res += int(i)*int(j)
print(res)