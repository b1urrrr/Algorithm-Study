n, m = map(int, input().split())
num = list(map(int, input().split())) + [0]
r = [0] * m

for i in range(n):
    num[i] += num[i-1] #숫자 정보를 누적합으로 갱신
    r[num[i] % m] += 1 # 해당 누적합을 m으로 나눴을 때의 나머지에 해당하는 값에 1 추가

cnt = r[0]

for i in r:
    cnt += i * (i-1) // 2

print(cnt)

