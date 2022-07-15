# 월간 코드 챌린지 시즌2
# 레벨1: 약수의 개수와 덧셈
def solution(left, right):
    result = 0
    for i in range(left, right+1):
        cnt = 0
        for j in range(1, i+1):
            if i%j == 0:
                cnt += 1
        if cnt % 2 == 0:
            result += i
        else:
            result -= i
    return result