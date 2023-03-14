# 그리디 알고리즘, 너비 우선 탐색
# 16953번: A → B

# 푸는 중
a, b = map(int, input().split())
res = 0
while True:
    if res >= b:
        break
    