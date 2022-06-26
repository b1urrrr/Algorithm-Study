# 누적합
#11660번: 구간 합 구하기 5
# 틀림(다시 풀기)
N, M = map(int, input().split())
#board = []
board = [[1, 2, 3, 4],[2, 3, 4, 5],[3, 4, 5, 6],[4, 5, 6, 7]]
#for i in range(N):
#    board.append(list(map(int, input().split())))

d = [[0]*1001]

for _ in range(M):
    x1, y1, x2, y2 = map(int ,input().split())
    res = 0
    while True:
        res += board[x1][y1]
        print(y1)
        if x1 == x2 and y1 == y2:
            break
        if y1 == N:
            y1 = -1
            x1 += 1
        y1 += 1
    print(res)