# 4, 9번 실패
# 코테 입문: 다음에 올 숫자
def solution(common):
    i1, i2 = common[1] - common[0], common[2] - common[1]
    if i1 == i2:
        answer = common[len(common)-1] + i1
    else:
        answer = common[len(common)-1] * i1
    return answer