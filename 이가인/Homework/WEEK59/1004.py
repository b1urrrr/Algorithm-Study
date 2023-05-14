import sys

t = int(sys.stdin.readline())

for i in range(t):
    x1, y1, x2, y2 = map(int, sys.stdin.readline().split())
    n = int(sys.stdin.readline())
    cnt = 0
    for _ in range(n):
        cx, cy, r = map(int, sys.stdin.readline().split())
        dis1 = (x1 - cx) ** 2 + (y1 - cy) ** 2
        dis2 = (x2 - cx) ** 2 + (y2 - cy) ** 2
        cr = r ** 2
        if (cr > dis1 and cr > dis2):
            continue
        elif (cr > dis1 or cr > dis2):
            cnt += 1
    print(cnt)
    