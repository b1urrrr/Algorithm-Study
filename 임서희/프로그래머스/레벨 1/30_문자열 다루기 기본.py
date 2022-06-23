# 연습 문제
# 문자열 다루기 기본
def solution(s):
    answer = True
    for i in s:
        if i.isalpha():
            answer = False
            break
    if len(s) !=6 and len(s) !=4:
        answer = False

    return answer

# 문자가 숫자인지 판별