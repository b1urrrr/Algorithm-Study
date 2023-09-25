# 연습문제
# 레벨2: 피보나치 수
# 1234567 모듈러 연산을 하는 이유: https://programmers.co.kr/questions/11991
# int 타입으로 표현할 수 있는 범위로 인해 1234567을 나머지 연산으로 나눠준다.

# 재귀함수로 작성한 피보나치
# 7, 10, 13, 14 런타임 에러: 재귀 함수 깊이 초과로 인한 런타임 에러 발생
d = [0] * 100001

def solution(n):
    if n == 1 or n == 2:
        return 1
    if d[n] != 0:
        return d[n]
    d[n] = (solution(n-1)%1234567 + solution(n-2)%1234567)%1234567
    return d[n]

# 반복문으로 작성한 피보나치: 보텀업
# 성공
dp = [0] * 100001
dp[1] = 1
dp[2] = 1

def solution(n):
    for i in range(3, n+1):
        dp[i] = (dp[i-2]%1234567 + dp[i-1]%1234567)%1234567
        
    
    return dp[n]

# 다른 사람 코드
def fibonacci(num):
    a,b = 0,1
    for i in range(num):
        a,b = b,a+b
    return a