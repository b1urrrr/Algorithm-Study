# 정렬
# 25325번: 학생 인기도 측정
n = int(input())
li = list(map(str, input().split()))
d = dict()
for i in range(n):
    d[li[i]] = 0
for _ in range(n):
    l = list(map(str, input().split()))
    for i in l:
        d[i] += 1
d = sorted(d.items(), key=lambda x:-x[1])
print(d)
for i in d:
    print(i[0], i[1])