# 백준 1946

t = int(input())

rank = []
for _ in range(t):
    n = int(input())
    rank = [list(map(int, input().split())) for _ in range(n)]
    sorted_rank = sorted(rank)
    top = 0
    result = 1

    for i in range(1, len(rank)):
        if sorted_rank[i][1] < sorted_rank[top][1]:
            top = 1
            res += 1
    
    print(res)
