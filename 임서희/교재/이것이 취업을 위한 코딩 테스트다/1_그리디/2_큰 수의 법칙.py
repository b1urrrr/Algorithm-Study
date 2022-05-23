# 큰 수의 법칙
# 내가 짠 코드
N, M, K = map(int, input().split())
a = list(map(int, input().split()))
A = sorted(a, reverse=True)

result = 0
i = 0
for _ in range(M): # 나도 M이 100억 이상이면 시간 초과가 날 것
    if i < K:
        result += A[0]
        i += 1
    else:
        result += A[1]
        i = 0
        
print(result)


# 큰 수의 법칙은 전형적인 그리디 알고리즘 문제
# 입력값 중에서 가장 큰 수와 두 번째로 큰 수만 저장하면 된다.
# 연속으로 더할 수 있는 횟수는 최대 K번이므로 '가장 큰 수를 K번 더하고 두 번째로 큰 수를 한 번 더하는 연산'을 반복

n, m, k = map(int, input().split())
data = list(map(int,input().split()))

data.sort()
first = data[n-1] # 가장 큰 수
second = data[n-2] # 두번쨰로 큰 수

result = 0

while True:
    for i in range(K): # 가장 큰 수를 K번 더하기
        if m == 0: # m이 0이라면 탈출
            break
        result += first
        m -= 1 # 더할 때마다 m에서 1씩 빼기(m은 전체 더하는 횟수)
    # 가장 큰 수를 K번 더했기 때문에 두 번째로 큰 수를 한 번 더하는 연산 진행
    if m == 0: # m이 0이라면 탈출
        break
    result += second # 두 번째로 큰 수 한 번 더하기
    m -= 1 # 더할 때 마다 m에서 1씩 빼기

print(result)


# 만약 위처럼 풀면 전체 더하는 횟수 M이 100억 이상일 경우 시간 초과 판정을 받게 된다.
# 따라서 간단한 수학적 아이디어로 더 효율적으로 문제를 푸는 방법을 생각해본다.
# 예를 들어 가장 큰 수가 6이고 두 번째로 큰 수가 5이며, M은 8, K가 3일 때를 살펴보자.
# (6 6 6 5) (6 6 6 5) 순서로 더하게 된다.

# 즉, '반복되는 수열'을 파악할 수 있다. 다시 말해 특정한 수열 형태로 일정하게 반복해서 더해지는 특징이 있다.
# 이처럼 반복되는 수열의 길이는 K+1이 된다. 따라서 M을 (K+1)로 나눈 몫이 수열이 반복되는 횟수가 된다. 
# 다시 여기에 K를 곱해주면 가장 큰 수가 등장하는 횟수가 된다.

# 중요한 것은 이떄 M이 (K+1)로 나누어떨어지지 않을 경우도 고려해야 한다. M%(K+1)만큼 가장 큰 수가 추가로 더해진다.
# 이 경우까지 고려하여 가장 큰 수가 등장하는 횟수는, int(M/(K+1))*K + M%(K+1) 이다.

# 고로 가장 큰 수가 몇 번 더해지는 것과 두 번째로 큰 수가 몇 번 더해지는지 횟수를 구해서 이를 result에 더해주면 된다.

n, m, k = map(int, input().split())
data = list(map(int, input().split()))

data.sort()
first = data[n-1]
second = data[n-2]

count = int(m/(k+1))*k
count += m % (k+1) # count는 가장 큰 수가 더해지는 횟수 (이걸 m에서 빼고 난 값이 두 번째로 큰 수 더하는 횟수)

result = 0
result += count * first # 가장 큰 수 더하기
result += (m-count) * second # 두 번째로 큰 수 더하기

print(result)