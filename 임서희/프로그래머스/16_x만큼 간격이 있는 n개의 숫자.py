# 연습 문제
# 레벨1: x만큼 간격이 있는 n개의 숫자
def solution(x, n):
    answer = []
    num = x
    for i in range(n):
        answer.append(num)
        num += x
    return answer

# 다른 사람 코드
def solution(x, n):
    answer = []
    for i in range(1,n+1):
        answer.append(x * i)
    return answer