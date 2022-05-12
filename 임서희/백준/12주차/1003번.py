# 피보나치 함수

# 동적 계획법: 큰 문제를 작은 문제로 나누어 푸는 문제

# Dynamic Programming의 조건
# 1. 작은 문제가 '반복'될 때
# 2. 작은 문제들 중에서 같은 문제의 결과 값이 항상 같을 때

# Bottom-up vs Top-down 중에서 하나만 적용되는 경우도 존재한다

# 동적 계획법을 사용해서 반복되는 규칙을 찾아, 시간 초과가 발생하는 것을 해결해야 한다.
# fibonacci(n) = fibonacci(n-1) + fibonacci(n-2)

a = int(input())
 
zero = [1,0,1]
one = [0,1,1]
 
def fibo(num):
    length = len(zero)
    if length <= num:
        for i in range(length,num+1):
            zero.append(zero[i-1]+zero[i-2])
            one.append(one[i-1]+one[i-2])
    print("%d %d"%(zero[num],one[num]))
 
for i in range(a):
    k = int(input())
    fibo(k)