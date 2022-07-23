# 수학, 브루트포스
# 1075번: 나누기
n = str(input())
n_int = int(n[:-2]+'00')
f = int(input())
res = 0
while True:
    if n_int % f == 0 or res >= 100:
        break
    res += 1
    n_int += 1

if res < 10:
    print('0'+str(res))
else:
    print(res)