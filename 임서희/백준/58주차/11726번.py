# 다이나믹 프로그래밍
# 11726번: 2xn 타일링

s = [0, 1, 2]
for i in range(3, 1001):
    s.append(s[i - 2] + s[i - 1])
n = int(input())
print(s[n] % 10007)