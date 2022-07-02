# 구현 및 문자열
# 1100번: 하얀 칸

chess = [[] for _ in range(8)]
n = 0

for _ in range(8):
    a = input()
    for i in a:
        chess[n].append(i)
    n+=1
white = 0
for i in range(8):
    for k in range(8):
        if chess[i][k] == 'F':
            if (i+k)%2 ==0:
                white += 1

print(white)