# 내 코드 80ms
N = int(input())
P = map(int, input().split())
p = sorted(P)
t = []
k = 0
sum = 0

for i in range(N):
    k += p[i]
    t.append(k)

for num in t:
    sum += num
    
print(sum)

# 다른 사람 코드 72ms
n = int(input())
result = 0
index = 0
time = list(map(int, input().split()))
time.sort()
for i in time:
    index += i
    result += index
print(result)