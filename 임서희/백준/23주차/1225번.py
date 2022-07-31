# 문자열
# 1225번: 이상한 곱셈
# 시간 초과
n, m = map(str, input().split())

res = 0
for i in n:
    for j in m:
        res += int(i)*int(j)
print(res)

# 시간 초과가 자꾸나서 다른 코드 참조
import sys
n,m = map(int, sys.stdin.readline().split())
n = list(map(int, n)) # n과 m 리스트의 문자열을 int로 변환
m = list(map(int, m))
print(sum(n)*sum(m))