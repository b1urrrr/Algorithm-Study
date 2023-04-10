# 수학
# 25206번: 너의 평점은
# 런타임 에러
h = {'A+':4.5, 'A0':4.0, 'B+':3.5, 'B0':3.0, 'C+':2.5, 'C0':2.0,
     'D+':1.5, 'D0':1.0, 'F':0, 'P':0}
r1 = 0
r2 = 0
for _ in range(20):
    subject = list(map(str, input().split()))

for i in subject:
    r1 += int(i[1])
    if i[2] == 'P':
        continue
    r2 += (int(i[1])*h[i[2]])
print(r2/r1)