# Summer/Winter Coding(~2018)
# 레벨1: 예산
def solution(d, budget):
    answer = 0
    d = sorted(d)
    num = 0
    for i in d:
        num+=i
        if num <= budget:
            answer+=1
    return answer