# 연습 문제
# 레벨1: 나누어 떨어지는 숫자 배열
def solution(arr, divisor):
    answer = []
    for a in arr:
        if a % divisor == 0:
            answer.append(a)
    if len(answer) < 1:
        answer.append(-1)
    else:
        answer = sorted(answer)
    return answer