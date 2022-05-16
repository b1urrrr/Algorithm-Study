# 팩토리얼 구현 2가지 방식

# 반복문
def factorial_iterative(n):
    result = 1
    for i in range(1,n+1):
        result *= i
    return result

# 재귀 함수
def factorial_recursive(n):
    if n <= 1:
        return 1
    return n * factorial_recursive(n-1)

print('반복적 구현: ', factorial_iterative(5)) # 120 출력
print('재귀적 구현: ', factorial_recursive(5)) # 120 출력

# 반복문 대신 재귀함수를 사용했을 때 장점
# 수학의 점화식(재귀식)을 그대로 소스코드로 옮겨서 재귀 함수의 코드가 더 간결하다.
# 수학에서 점화식은 '특정한 함수를 자신보다 더 작은 변수에 대한 함수와의 관계로 표현'한 것을 의미한다.
# 이는 곧 다이나믹 프로그래밍(동적 프로그래밍)과 연결되므로 중요하다.

# 점화식에는 일반적으로 종료 조건을 찾을 수 있다.
# 이를 고려하지 않으면 재귀 함수가 무한히 반복되어 결과를 출력하지 못할 수 있다.