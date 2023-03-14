n = int(input())
s = list(map(int, input().split()))
s.sort()
w = []
for j in range(n):
    w.append(s[j] + s[2*n-j-1])

print(min(w))