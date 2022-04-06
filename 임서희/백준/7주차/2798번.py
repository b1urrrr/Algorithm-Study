# 틀린 내 코드
N, M = map(int,input().split())
a = list(map(int, input().split()))
a.sort()
def black(a):
    for i in range(0, len(a)-2):
        for k in range(i+1, len(a)-1):
            for j in range(k+1, len(a)):
                if a[i]+a[j]+a[k] ==M:
                    return M
                else:
                    return a[i]+a[j]+a[k-1]
print(black(a))

# 맞는 다른 사람 코드
n, m = map(int, input().split())
num = list(map(int, input().split()))
l = len(num)
ans = 0
for i in range(0, l-2):
    for j in range(i+1, l-1):
        for k in range(j+1, l):
            if(num[i] + num[j] + num[k] > m):
                continue
            else:
                ans = max(ans ,num[i] + num[j] + num[k])
print(ans)

# 맞는 다른 사람 코드 2
n, m = map(int, input().split())
numlist = list(map(int, input().split()))

answer = 0

for i in range(len(numlist)):
    for j in range(i + 1, len(numlist)):
        for k in range(j + 1, len(numlist)):
            sum = numlist[i] + numlist[j] + numlist[k]
            if sum <= m:
                answer = max(answer, sum) # M과 가까운 최대값을 찾아나감
print(answer)