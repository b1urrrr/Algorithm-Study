# 정렬
# 2822번: 점수 계산
score = dict()
res = 0
res_l = []
for i in range(8):
    score[i] = int(input())
score = sorted(score.items(), key = lambda x:x[1], reverse=True)

for i in range(5):
    res += score[i][1]
print(res)

for i in range(5):
    res_l.append(score[i][0] + 1)

res_l = sorted(res_l)
for i in res_l:
    print(i, end= ' ')