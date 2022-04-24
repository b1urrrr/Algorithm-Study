# 시간 초과
N = int(input())
num = []

for _ in range(N):
    a = int(input())
    num.append(a)

num_list = [0] * 100
res = []
for i in range(2,num[N-1]+1):
    k = 0
    bo = True
    for n in num:
        num_list[k] = n%i
        k+=1
    for j in range(1, N):
        if num_list[j] != num_list[j-1]:
            bo = False
            break
    if bo:
        res.append(i)

for i in res:
    print(i, end=' ')

# 다시 풀기