# 레벨1
# 연습문제
# 2016
def solution(a, b):
    month = [0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
    day = ['THU','FRI','SAT','SUN','MON','TUE','WED']
    
    d = 0
    for i in range(a):
        d+=month[i]
    d += b
    d %= 7
    return day[d]
