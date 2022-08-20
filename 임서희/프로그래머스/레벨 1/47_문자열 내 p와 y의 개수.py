# 연습문제
# 문자열 내 p와 y의 개수
def solution(s):
    s = s.lower()
    p_sum = 0
    y_sum = 0
    for i in s:
        if i == 'p':
            p_sum += 1
        elif i == 'y':
            y_sum += 1

    return True if p_sum == y_sum else False

# 다른 사람 풀이: count 함수 이용하기
def numPY(s):
    return s.lower().count('p') == s.lower().count('y')