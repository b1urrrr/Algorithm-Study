# 연습 문제
# 레벨1: 명예의 전당(1)

# 푸는 중
def solution(k, score):
    res= sorted(score[:k])
    answer = [res[0] for _ in range(k)]
    j = 0
    for i in range(k, len(score)):
        
        if res[j] < score[i]:
            res.append(score[i])
            j += 1
        answer.append(res[j])
        print(res)

    return answer

# 참고 코드
def solution(k, score):
    answer = []
    li = []
    for s in score:
        li.append(s)
        li = sorted(li, reverse=True)[:k]

        answer.append(min(li))
    return answer