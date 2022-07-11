# 월간 코드 챌린지 시즌1
# 레벨1: 내적
# 걸린 시간: 5분
def solution(a, b):
    return sum([a[i]*b[i] for i in range(len(a))])