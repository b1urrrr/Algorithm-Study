# 월간 코드 챌린지 시즌3
# 레벨1: 없는 숫자 더하기
# 걸린 시간: 5분
def solution(numbers):
    num = 0
    for i in range(0,10):
        num += i
    for n in numbers:
        num -= n
    return num

# 다른 사람 코드1
def solution(numbers):
    return sum([i for i in [1,2,3,4,5,6,7,8,9,0] if i not in numbers])

# 다른 사람 코드2
def solution(numbers):
    return 45 - sum(numbers)