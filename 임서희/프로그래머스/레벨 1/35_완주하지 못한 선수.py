# 해시
# 레벨1: 완주하지 못한 선수
# 걸린 시간: 14분
def solution(participant, completion):
    part = dict()
    for i in participant:
        part[i] = 0
    for i in participant:
        part[i] += 1
    for i in completion:
        part[i] -= 1
    answer = ""
    for key,value in part.items():
        if value != 0:
            answer = key
    return answer

# 다른 사람 코드
import collections

def solution(participant, completion):
    answer = collections.Counter(participant) - collections.Counter(completion)
    return list(answer.keys())[0]