# 정렬, 그리디 알고리즘
# 10610번: 30
a = input()
a = sorted(a, reverse=True)
res = ''
for i in a:
    res += i
res = int(res)

if res%30 == 0:
    print(res)
else:
    print(-1)