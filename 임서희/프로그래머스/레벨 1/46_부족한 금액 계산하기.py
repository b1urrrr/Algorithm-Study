# 위클리 챌린지
# 레벨1: 부족한 금액 계산하기
def solution(price, money, count):
    answer = 0
    for i in range(1,count+1):
        answer += price*i

    return 0 if money>=answer else answer-money 