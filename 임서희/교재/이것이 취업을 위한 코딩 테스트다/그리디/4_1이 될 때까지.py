# 1이 될 때까지
# 내가 짠 코드: 이러면 최적의 해를 보장 못한다고 예상
N, K = map(int,input().split())
cnt = 0
while N != 1:
    if N%K == 0:
        N//=K
    else:
        N-=1
    cnt += 1
print(cnt)

# 이 문제를 해결하기 위한 아이디어를 떠올리면 쉽게 해결할 수 있다.
# 주어진 N에 대하여 '최대한 많이' 나누기를 수행하면 된다.
# 따라서 N이 K의 배수라면 나누는 것이 1을 빼는 것보다 숫자를 더 빠르게 줄일 수 있다.
# 그러므로 N이 K의 배수가 될 때까지 1로 빼고, 그 후 N을 K로 나누면 된다.
# 이것이 최적의 해를 보장한다는 것은, K가 2 이상이기만 하면 K로 나누는 것이 1을 빼는 것보다 항상 빠르게 N의 값을 줄일 수 있기 때문이다.


# 단순한 풀이
n, k = map(int, input().split())
result = 0

# n이 k 이상이라면 k로 계속 나누기
while n >= k:
    # n이 k로 나누어 떨어지지 않으면 n에서 1씩 빼기 → n이 k의 배수가 되도록 만들기
    while n % k != 0:
        n -= 1
        result += 1
    # k로 나누기
    n //= k
    result += 1

# 남은 수는 1씩 빼주기
while n > 1:
    n -= 1
    result += 1

print(result) 


# 정리된 답안
n, k = map(int, input().split())
result = 0

while True:
    # n == k 로 나누어 떨어지는 수가 될 때까지 1씩 빼주기
    target = (n//k) * k
    result += (n-target)
    n = target
    # n이 k보다 작을 때(더 이상 나누지 못할 때) 반복문 탈출
    if n < k:
        break
    # k로 나누기
    result += 1
    n //= k

# 마지막으로 남은 수에 대하여 1씩 빼기
result += (n-1)
print(result)
