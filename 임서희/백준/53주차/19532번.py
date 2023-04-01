# 브루트포스
# 19532번: 수학은 비대면 강의입니다
a, b, c, d, e, f = map(int, input().split())

# -999~999로 범위가 나와 있기 때문에 이중 for문을 이용하여 해당 식이 성립하는 값을 찾는 방식으로 구할 수 있음
for i in range(-999, 1000):
    for j in range(-999, 1000):
        if (a*i) + (b*j) == c and (d*i) + (e*j) == f:
            print(i,j)
