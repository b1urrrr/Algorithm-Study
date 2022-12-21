# 브루트포스 알고리즘
# 2501번: 약수 구하기
n, k = map(int, input().split())
cnt = 0
for i in range(1, n+1):
    if n%i == 0:
        cnt += 1
    if cnt == k:
        print(i)
        break
else: print(0)