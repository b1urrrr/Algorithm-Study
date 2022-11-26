# 정렬, 그리디
# 1449번: 수리공 항승
n, l = map(int, input().split()) # n 물이 새는 곳, l 테이프의 길이
li = list(map(int, input().split())) 
li.sort()
max = li[n-1]
p = [False] * (max+1)
res = 0

for i in li:
    if li[i] == True:
        continue
    for k in range(l):
        li[i+k] = True
    res += 1
