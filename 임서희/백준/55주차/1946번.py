# 그리디 알고리즘
# 1946번: 신입 사원

# 생각중...
t  = int(input())
li = []
for _ in range(t):
    n = int(input())
    for i in range(n):
        li.append(map(int,input().split()))

# 참고 코드
T = int(input())

for _ in range(T):
    N = int(input())
    rank = [list(map(int, input().split())) for _ in range(N)]
    rank_asc = sorted(rank)
    top = 0
    result = 1
    
    for i in range(1, len(rank_asc)):
        if rank_asc[i][1] < rank_asc[top][1]:
            top = i
            result += 1
    
    print(result)