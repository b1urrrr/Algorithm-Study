# 정렬, 브루트포스
# 2548번: 대표 자연수
# 내가 짠 코드: 시간초과
n = int(input())
#li = sorted(list(map(int, input().split())))
li = list(map(int, input().split()))
min_sum = 1e9
res = []

for i in li:
    s = 0
    for j in li:
        s += abs(j-i)
    if s <= min_sum:
        res.append([s,i])
        min_sum = s

res = sorted(res, key=lambda x:(x[0],x[1]))
print(res[0][1])