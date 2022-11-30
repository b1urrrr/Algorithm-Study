# 정렬, 시뮬레이션, 구현
# 조금 더 생각해보기
n, k = map(int, input().split())
li = list(map(int, input().split()))
res = 0
for i in range(1, n+1):
    max_v = 0
    for j in range(n-i):
        print(':,', max_v, li[j])
        if max_v < li[j]:
            max_v = j
            print(':,', max_v, li[j])
    if li[max_v] != li[n-i]:
        li[j], li[n-i] = li[n-i], li[j]
        res += 1
        print(li[j], li[n-i])
        print(li)
    if res == k:
        print(k, li[j], li[n-i])
        print(li)
        break