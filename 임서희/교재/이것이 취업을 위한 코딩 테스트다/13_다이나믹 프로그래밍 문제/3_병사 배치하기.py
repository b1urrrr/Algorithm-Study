n = int(input())
li = list(map(int, input().split()))
li.reverse()

dp = [1] * n
for i in range(1, n):
	for j in range(0, i):
		if li[j] < li[i]:
			dp[i] = max(dp[i], dp[j] + 1)
print(n - max(dp))