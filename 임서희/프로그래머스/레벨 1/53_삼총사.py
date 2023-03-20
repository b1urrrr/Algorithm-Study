# 연습 문제
# 레벨1: 삼총사
def solution(number):
    answer = 0
    for i in range(0,len(number)-2):
        for j in range(i+1, len(number)-1):
            for k in range(j+1, len(number)):
                if number[i]+number[j]+number[k] == 0:
                    #print(number[i],number[j],number[k])
                    answer+=1
    return answer

# 다른 사람 코드
# 모듈 이용하기
def solution (number) :
    from itertools import combinations
    cnt = 0
    for i in combinations(number,3) :
        if sum(i) == 0 :
            cnt += 1
    return cnt