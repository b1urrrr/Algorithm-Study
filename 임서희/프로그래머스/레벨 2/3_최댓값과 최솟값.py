# 연습 문제
# 레벨2: 최댓값과 최솟값
def solution(s):
    answer = []
    s = list(s.split(" "))
    s = [int(i) for i in s]
    answer.append(min(s))
    answer.append(max(s))
    return str(answer[0]) + " " + str(answer[1])

def solution(s):
    s = list(s.split(" "))
    s = [int(i) for i in s]
    s = sorted(s)
    return str(s[0]) + " " + str(s[-1])

# 다른 사람 풀이
def solution(s):
    s = list(map(int,s.split()))
    return str(min(s)) + " " + str(max(s))