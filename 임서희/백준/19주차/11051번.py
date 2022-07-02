# 11051번: 이항 계수 2
# 팩토리얼(파스칼 삼각형)을 dp를 이용하여 구현

# 다른 사람 코드
# 풀이 1
n, k = map(int, input().split())
dp = [[0] * 1 for i in range(1001)]
dp[1].append(1)
for i in range(2, 1001):
    for j in range(1, i + 1):
        if j == 1:
            dp[i].append(1)
        elif j == i:
            dp[i].append(1)
        else:
            dp[i].append(dp[i - 1][j - 1] + dp[i - 1][j])
print(dp[n + 1][k + 1] % 10007)

# 풀이 2
import sys
input = sys.stdin.readline

N, K = map(int, input().split())

result = 1
for i in range(K):
    result *= N
    N -= 1

divisor = 1
for i in range(2, K+1):
    divisor *= i

print((result // divisor) % 10007)