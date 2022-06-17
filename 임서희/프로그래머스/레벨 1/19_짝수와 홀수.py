# 연습 문제
# 레벨1: 짝수와 홀수
def solution(num):
    return 'Even' if num%2==0 else 'Odd'

# 다른 사람 코드 1
def solution(num):
    return "Odd" if num%2 else "Even"

# 다른 사람 코드 2
def evenOrOdd(num):
    return ["Even", "Odd"][num & 1]

# 파이썬 문법
# & 연산자(비트 연산자)