import sys
input = sys.stdin.readline()

x, y = map(int, input.split())
z = y * 100 // x

left = 0
right = x
res = x

if (z >= 99):
    print(-1) 
else:
    while (left <= right):
        mid = (left + right) // 2
        if (z < (y + mid) * 100 // (x + mid)):
            res = mid
            right = mid - 1
        else:
            left = mid + 1
    print(res)