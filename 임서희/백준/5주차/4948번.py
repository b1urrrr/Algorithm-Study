# 내 코드: 시간 초과
while True:
    n = int(input())
    if n == 0:
        break

    sum = 0
    for num in range(n+1, 2*n+1):
        if num == 2:
            sum+=1
            continue
        else:
            for i in range(2, int(num**0.5)+1):
                if num % i == 0:
                    break
            else:
                sum+=1
    print(sum)
            
# 다른 사람 코드
# 미리 최대 n의 소수를 모두 구해서 시간 효율 얻기
# 에라토스테네스의 체 이용
N = 123456 * 2 + 1
sosu = [True] * N

for i in range(2, int(N**0.5)+1): # 미리 소수 구하기
    if sosu[i]:
        for j in range(2*i, N, i):
            sosu[j] = False

def prime_cnt(v):
    cnt = 0
    for i in range(v+1, 2*v+1):
        if sosu[i]:
            cnt += 1
    print(cnt)

while True:
    v = int(input())
    if v == 0:
        break
    prime_cnt(v)