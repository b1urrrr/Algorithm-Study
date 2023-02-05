# 동적 계획법 (DP)
# 1932번: 정수 삼각형
# 생각 중
n = int(input())
#dp = [[0]*i for i in range(1,n+1)]
#li = []
#for i in range(n):
#    li.append(list(map(int,input().split())))
#dp[0][0] = li[0][0]
#print(dp)
#print(li)
dp =[[7], [0,0], [0, 0, 0], [0, 0, 0, 0], [0, 0, 0, 0, 0]]
li = [[7], [3, 8], [8, 1, 0], [2, 7, 4, 4], [4, 5, 2, 6, 5]]
for i in range(1,n):
    for j in range(i+1):
        print(li[i-1][j-1]+li[i-1][j])
        # 인덱스 에러 발생
        #dp[i][j] = max(dp[i-1][j-1]+dp[i-1][j]) + li[i][j] # 범위를 어떻게 줄지 생각중
        print(li)                        