# 구현, 선형대수학
# 2740번: 행렬 곱셈
# n*m과 m*k 행렬은 n*k 행렬을 만든다
n, m = map(int, input().split())
li_1 = []
li_2 = []
for _ in range(n):
    li_1.append(list(map(int, input().split())))
m, k = map(int, input().split())
for _ in range(m):
    li_2.append(list(map(int, input().split())))

c=[[0 for _ in range(k)] for _ in range(n)]
for i in range(n):
    for j in range(k):
        for l in range(m):
            c[i][j] += li_1[i][l] * li_2[l][j]

for i in c:
    for j in i:
        print(j, end = ' ')
    print()