# 동적 계획법 (Dynamic Programming)
# 큰 문제를 작은 문제로 나누어 푸는 문제

# 분할 정복(Divide and Conquer)과의 차이점
# 분할 정복은 단이 큰 문제를 작은 문제로 나누어 푸는 방법
# 동적 계획법은 작은 부분 문제들이 '중복(반복)'되는 걸 이용해서 푸는 방법
# 또한, 작은 부분 문제의 '답이 항상 같아야 함'

# 따라서 Dynamic Programming의 조건
# 1. 작은 문제가 반복될 때
# 2. 작은 문제들 중에서 같은 문제의 결과 값이 항상 같을 때

# Memoization(메모이제이션)
# 작은 문제들이 반복되고, 이 작은 문제들의 결과값이 항상 같을 때 동적 프로그래밍
# 이를 저장해놓고 다시 사용하는 걸 'Memoization'이라고 함

# Bottom-up vs Top-down
# 둘 중 하나로 풀리는 문제가 존재하기도 한다.

# Bottom-up
# 작은 문제부터 차근차근 구해나가는 방법
# 풀기는 쉽지만 소스 가독성이 저하되기도 함

# Top-down
# 큰 문제를 풀 때 작은 문제가 아직 풀리지 않은 경우에 작은 문제를 해결
# 보통 재귀함수로 구현하는 경우 해당
# 소스 가독성은 증가되지만 작성이 다소 어려움

# 시간 초과
T = int(input())

def fibonacci(n):
    if n==0:
        global sum_0
        sum_0 += 1
        return 0
    elif n==1:
        global sum_1
        sum_1 += 1
        return 1
    else:
        return fibonacci(n-1)+fibonacci(n-2)

for _ in range(T):
    global sum_0, sum_1
    sum_0 = 0
    sum_1 = 0
    num = int(input())
    fibonacci(num)
    print(f'{sum_0} {sum_1}')
    
# 다른 사람 코드(DP 이용)
# fibonacci(n) = fibonacci(n-1) + fibonacci(n-2)
# 즉, (n에서 0과 1 호출 횟수) = (n-1에서 0과 1 호출 횟수) + (n-2에서 0과 1 호출 횟수)

# 다시 풀어보기

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
