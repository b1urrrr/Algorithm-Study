# BOJ 1459 걷기 - 실버 3

x, y, w, s = map(int, input().split())

# 1. 평행이동
m1 = (x + y) * w

# 2. 대각선 이동
if (x + y) % 2 == 0:
    m2 = max(x, y) * s
else: # 대각선 이동 후 1번 평행이동
    m2 = (max(x, y) - 1) * s + w

# 3. 대각선 이동 + 평행이동
m3 = (min(x, y) * s) + (abs(x - y) * w)

print(min(m1, m2, m3))
