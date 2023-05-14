# 브루트포스 알고리즘
# 2798번: 블랙잭

n, m = map(int, input().split())
numlist = list(map(int, input().split()))

answer = 0

for i in range(len(numlist)):
    for j in range(i + 1, len(numlist)):
        for k in range(j + 1, len(numlist)):
            sum = numlist[i] + numlist[j] + numlist[k]
            if sum <= m:
                answer = max(answer, sum)
print(answer)