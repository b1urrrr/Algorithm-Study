# 정렬
# 25496번
a = list(map(int, input().split()))
b = sorted(list(map(int, input().split())))

cnt = 0

for n in range(a[1]):
    if a[0] >= 200:
        break
    a[0] = a[0] + b[cnt]
    cnt += 1

print(cnt)