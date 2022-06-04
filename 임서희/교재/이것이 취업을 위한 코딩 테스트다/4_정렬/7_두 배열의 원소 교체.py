# 정렬
# 두 배열의 원소 교체
n , k = map(int, input().split())
a = list(map(int, input().split()))
b = list(map(int, input().split()))
a.sort()
b.sort(reverse=True)

for i in range(k):
    if a[i] < b[i]:
        a[i], b[i] = b[i], a[i]

print(sum(a))

# 답안 예시
n , k = map(int, input().split())
a = list(map(int, input().split()))
b = list(map(int, input().split()))
a.sort()
b.sort(reverse=True)

for i in range(k):
    if a[i] < b[i]:
        a[i], b[i] = b[i], a[i]
    else: # 이미 정렬이 되어 있기 때문에 A의 원소가 B원소보다 크거나 같은 때가 오면
        break # 그 이후로 A 원소가 계속 크므로 반복문 돌 필요 없이 break

print(sum(a))
