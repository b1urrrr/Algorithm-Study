# 정렬
# 7795번: 먹을 것인가 먹힐 것인가
# 이전 내코드: 시간 초과
t = int(input())
for _ in range(t):
    n, m = map(int, input().split())
    res = 0
    a = sorted(list(map(int, input().split())), reverse=True)
    b = sorted(list(map(int, input().split())))
    for i in b:
        for j in a:
            if i >= j:
                break
            else:
                res += 1
    print(res)

for _ in range(int(input())):
    N, M = map(int, input().split())
    A = list(map(int, input().split()))
    B = list(map(int, input().split()))
 
    A.sort()
    B.sort()
 
    count = 0
    pair = 0
 
    for i in range(N):
        while True:
            if count == M or A[i] <= B[count]:
                pair += count
                break
            else:
                count += 1
 
    print(pair)