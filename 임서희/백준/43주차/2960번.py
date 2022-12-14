# 수학, 에라토스테네스의 체
# 2960번: 에라토스테네스의 체
# 조금 더 생각해보기
n, k = map(int, input().split())
b = [i for i in range(0,n+1)]
print(b)
cnt = 0
for i in range(2, n+1):
    if b[i] != 0:
        b[i] = 0
        cnt += 1
        if cnt == k:
            print(i, cnt)
            break
        for j in range(i, (n-1)//i):
            print(j)
            b[j*i] = 0
            print(b)
            cnt += 1
            if cnt == k:
                print(b[j*i])
                break
        print(b)


# 에라토스테네스의 체 코드
N = int(input())
sum = N

a = list(map(int, input().split()))

for i in range(len(a)):
    if a[i] == 1:
        sum -= 1
        continue
    k = a[i] - 1
    while k > 1:
        if a[i]%k == 0:
            sum -= 1
            break
        k -= 1
print(sum)