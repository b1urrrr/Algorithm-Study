# 수학, 그리디 알고리즘
# 10162번: 전자레인지

n = int(input())
elec = [300, 60, 10]
res = [0, 0, 0]

for i in range(len(elec)):
    if n < elec[i]:
        continue
    res[i] = n//elec[i]
    n %= elec[i]

if n != 0:
    print(-1)
else:
    for i in res:
        print(i, end = ' ')