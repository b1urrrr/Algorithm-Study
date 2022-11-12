# 정렬
# 16435번: 스네이크버드
n, l = map(int, input().split())
li = sorted(list(map(int, input().split())))
res = l
for i in li:
    if res < i:
        break
    res += 1
print(res)