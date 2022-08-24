# 연습문제
# 레벨1: 자릿수 더하기
# 내 코드
def solution(n):
    answer = 0
    for i in str(n):
        answer += int(i)
    return answer

# 다른 사람 코드
def sum_digit(number):
    return sum([int(i) for i in str(number)])