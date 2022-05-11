# 블랙잭

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