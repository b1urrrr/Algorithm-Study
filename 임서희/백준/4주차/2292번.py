# 내 코드
sum = 1
N = int(input())
i = 1

while N > sum:
    sum += 6*i
    i += 1
    
print(i)

# 다른 사람 코드
n = int(input())

nums_pileup = 1
cnt = 1
while n > nums_pileup :
    nums_pileup += 6 * cnt
    cnt += 1
print(cnt)