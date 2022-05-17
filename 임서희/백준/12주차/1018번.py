# 브루트포스
# 체스판 다시 칠하기

N, M = map(int, input().split())
original = []
count = []

for _ in range(N):
    original.append(input()) # 원래 판 입력 받기

for a in range(N-7):
    for b in range(M-7):
        index1 = 0 # W로 시작할 때 체스판 개수 세기
        index2 = 0 # B로 시작할 때 체스판 개수 개시
        for i in range(a, a+8):
            for j in range(b, b+8):
                if (i+j) % 2 == 0:
                    if original[i][j] != 'W':
                        index1 += 1
                    if original[i][j] != 'B':
                        index2 += 1
                else:
                    if original[i][j] != 'B':
                        index1 += 1
                    if original[i][j] != 'W':
                        index2 += 1
        count.append(min(index1, index2))

print(min(count))