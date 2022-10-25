# 배열, 구현
# 2738번: 행렬 덧셈
n, m = map(int, input().split())
li_n = list()
li_m = list()

for _ in range(n):
    li_n.append(list(map(int, input().split())))
for _ in range(n):
    li_m.append(list(map(int, input().split())))
for i in range(n):
    for j in range(m):
        print(li_n[i][j]+li_m[i][j], end = ' ')
    print()