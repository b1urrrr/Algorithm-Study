# 연습 문제
# 레벨1: 크기가 작은 부분 문자열
def solution(t, p):
    answer = 0
    for i in range(len(t)-len(p)+1):
        if int(t[i:i+len(p)]) <= int(p):
            answer += 1
    return answer