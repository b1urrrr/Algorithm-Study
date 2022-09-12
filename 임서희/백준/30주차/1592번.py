# 구현
# 1592번: 영식이와 친구들
n,m,l = map(int, input().split())
l = [0] * n
i = 0
cnt = 0
while l[i] < m-1:
    l[i] += 1
    cnt += 1
    i = (i+l)%n if l[i]%2 == 1 else (i-l)%n
print(cnt)