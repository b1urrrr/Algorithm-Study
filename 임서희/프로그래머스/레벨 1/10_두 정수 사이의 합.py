# 연습 문제
# 레벨1: 두 정수 사이의 합
def solution(a, b):
    answer = 0
    if a > b:
        a, b = b, a
    for i in range(a,b+1):
        answer += i
    return answer

# 다른 사람 코드
def solution(a, b):
    return sum(range(min(a, b), max(a, b) + 1))