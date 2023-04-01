# 정렬
# 20291번: 파일 정리
n = int(input())
li = []
for _ in range(n):
    li.append(input().split('.'))
d = dict()

for i in range(n):
    if li[i][1] not in d:
        d[li[i][1]] = 1
    else:
        d[li[i][1]] += 1

d = sorted(d.items())

for i in d:
    print(i[0], i[1])
        