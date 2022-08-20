# 기하학
# 1358번: 하키
w, h, x, y, p = map(int, input().split())
num = 0
for _ in range(p):
    a, b = map(int, input().split())
    if (x <= a <= x+w) and (y <= b <= y+h):
        num +=1
        continue
    
    r = h/2
    r1 = ((a-x)**2 + (b-(y+r))**2)**0.5
    r2 = ((a-(x+w))**2 + (b-(y+r))**2)**0.5
    if r1 <= r or r2 <= r:
        num += 1

print(num)