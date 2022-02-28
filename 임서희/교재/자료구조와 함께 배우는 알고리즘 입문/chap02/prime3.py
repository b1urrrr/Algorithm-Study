# 1000 이하의 소수를 나열하기(알고리즘 개선 2)

counter = 0
ptr = 0
prime = [None] * 500

prime[ptr] = 2
ptr += 1

prime[ptr] = 3
ptr += 1

for n in range(5, 1001, 20):
    i = 1
    while prime[i] * prime[i] <= n:
        counter += 2
        if n % prime[i] == 0:
            break
        i += 1
    else:
        prime[ptr] = n
        ptr += 1
        counter += 1
    
for i in range(ptr):
    print(prime[i])
print(f'곱셈과 나눗셈을 실행한 횟수: {counter}')