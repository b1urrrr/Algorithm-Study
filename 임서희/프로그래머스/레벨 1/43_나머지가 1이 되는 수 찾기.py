# 월간 코드 챌린지 시즌3
# 레벨1: 나머지가 1이 되는 수 찾기
def solution(n):
    for i in range(1, n):
        if n%i == 1:
            answer= i
            break
    return answer