# 2021 Dev-Matching
# 레벨1: 로또의 최고 순위와 최저 순위
# 걸린 시간: 10분
def solution(lottos, win_nums):
    win = [6, 6, 5, 4, 3, 2, 1]
    num = 0
    num_0 = 0
    for i in lottos:
        if i in win_nums:
            num += 1
        elif i == 0:
            num_0 += 1
    return [win[num+num_0],win[num]]