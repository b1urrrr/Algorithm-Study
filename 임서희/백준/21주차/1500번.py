# 수학
# 1500: 최대 곱

# S//k의 몫으로 K개에 고르게 나눠주고, 나눴을 때의 나머지(S%K)개에만 1을 더한 것
s, k = map(int, input().split())
li = [s//k for _ in range(k)]
for i in range(s%k):
    li[i] += 1
res = 1
for n in li:
    res *= n
print(res)