# 연습 문제
# 레벨1: 과일 장수
def solution(k, m, score):
    answer = 0
    score = sorted(score, reverse=True)
    new = []
    for i in range(0, len(score)-m+1, m):
        new.append(score[i:i+m])
    for i in range(len(new)):
        answer += (new[i][m-1] * m)
    return answer

# 다른 사람 코드
def solution(k, m, score):
    return sum(sorted(score)[len(score)%m::m])*m