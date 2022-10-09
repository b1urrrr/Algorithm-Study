# 정렬
# 2822번: 점수 계산
score = []
for i in range(8):
    score.append(int(input()))
score_sort = sorted(score, reverse=True)
big = []
for i in range(5):
    big.append(score_sort[i])
sum = 0
tmp = []
for i in big:
    sum += i
    tmp.append(score.index(i))
print(sum)
tmp_s = sorted(tmp)
for i in tmp_s:
    print(i + 1, end=' ')