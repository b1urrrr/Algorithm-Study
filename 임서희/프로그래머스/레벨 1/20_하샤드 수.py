# 연습문제
# 레벨 1: 하샤드 수
def solution(x):
    s = 0
    x_list = str(x)
    for i in x_list:
        s += int(i)
    return False if x % s else True

# 다른 사람 코드
def solution(n):
    return n % sum([int(c) for c in str(n)]) == 0