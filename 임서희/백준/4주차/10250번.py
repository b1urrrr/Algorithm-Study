# 내 코드 1
T = int(input())
for _ in range(T):
    H, W, N = map(int, input().split())
    sum = 0
    i = 0 # 열
    
    while N > sum:
        i += 1
        sum = H*i
        
    k = N-H*(i-1) # 행
    print(f'{k}{i:02d}')

# 내 코드 2
T = int(input())
for _ in range(T):
    H, W, N = map(int,input().split())
    if N%H ==0:
        i = N//H
    else:
        i = N//H + 1
    k = N-H*(i-1) # 행
    print(f'{k}{i:02d}')