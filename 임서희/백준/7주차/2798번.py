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