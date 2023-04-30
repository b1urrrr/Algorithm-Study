# 분할 정복
# 1780번: 종이의 개수

n = int(input())

b = [list(map(int, input().split())) for _ in range(n)]
minus = 0
zero = 0
plus = 0

def dfs(x, y, n):
    global minus, zero, plus

    check = b[x][y]

    for i in range(x, x+n):
        for j in range(y, y+n):
            if (b[i][j] != check):
                for k in range(3):
                    for l in range(3):
                        dfs(x + k * n //3, y + l * n // 3, n // 3)
                return
    
    if check == -1:
        minus += 1
    elif check == 0:
        zero += 1
    else:
        plus += 1

dfs(0, 0, n)
print(minus)
print(zero)
print(plus)