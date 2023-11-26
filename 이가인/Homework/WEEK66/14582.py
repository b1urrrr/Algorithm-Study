# BOJ 14582 오늘도 졌다 - 실버 5
a = list(map(int, input().split()))
b = list(map(int, input().split()))
a_score = 0
b_score = 0
res = 0

for i in range(9):
    a_score += a[i]
    # 역전하는 지 검사
    if a_score > b_score:
        res = 1
    b_score += b[i]

if sum(a) < sum(b) and res == 1:
    print('Yes')
else:
    print('No')