# 정렬, 그리디 알고리즘
# 내코드: 틀림
n = int(input())
li = sorted(list(map(int, input().split())), reverse= True)
day = li[0]-1
res = li[0] + 1

for i in range(1, len(li)):
    if day <= li[i]:
        res += abs(day-li[i])
    day -= 1
print(res)