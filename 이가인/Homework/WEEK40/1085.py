x, y, w, h = map(int, input().split())

dist = [x, y, abs(x-w), abs(y-h)]

print(min(dist))