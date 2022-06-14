# 연습문제
# 레벨1: 수박수박수박수박수박수?
def solution(n):
    answer = "수박"
    if n%2 == 1:
        answer = answer *(n//2) + "수"
    else:
        answer = answer * (n//2)
    return answer