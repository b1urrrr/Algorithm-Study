# 분할 정복
# 2630번: 색종이 만들기

n = int(input())
b = [list(map(int, input().split()))]
blue = 0
white = 0

def s(x,y,n):
    global white, blue
    color = b[x][y]
    for i in range(x, x+n):
        for j in range(y, y+n):
            if color != b[i][j]:
                s(x,y,n//2)
                s(x,y+n//2,n//2)
                s(x+n//2,y,n//2)
                s(x+n//2,y+n//2,n//2)
                return
    if color == 0:
        white += 1
    else:
        blue += 1

s(0,0,n)
print(white)
print(blue)