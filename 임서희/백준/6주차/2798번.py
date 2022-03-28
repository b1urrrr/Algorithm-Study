# 내 코드
N, M = map(int,input().split())

black_list = sorted(list(map(int, input().split())))

max = 0
result_list = []

for i in range(N-2):
    a = black_list[i]
    for j in range(i+1, N-1):
        b = black_list[j]
        for k in range(j+1,N):
            c = black_list[k]
            result_list.append(a+b+c)
result_list.sort()

for i in range(len(result_list)):
    if result_list[i] > M:
        print(result_list[i-1])
        break