# 그리디 알고리즘
# 14659번: 한조서열정리하고옴

# 답은 나오는데, 백준에서 시간 초과 발생
import sys
n = int(input())
li = list(map(int, sys.stdin.readline().split()))
res = 0
for i in range(n-1):
    res_i = 0
    for j in range(i+1,n):
        #print(li[i], li[j])
        if li[i] < li[j]:
            break
        res_i += 1
    res = max(res, res_i)
print(res)

# 다른 사람 코드 참고
n = int(input())
li = list(map(int, input().split()))
max_hill = 0
cnt = 0
res = 0

for l in li:
    if l > max_hill:
        max_hill = l
        cnt = 0
    else:
        cnt += 1
    res = max(res, cnt)
print(res)