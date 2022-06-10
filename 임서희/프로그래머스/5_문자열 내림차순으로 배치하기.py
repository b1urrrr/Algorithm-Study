# 연습문제
# 문자열 내림차순으로 배치하기
# 내 코드
def solution(s):
    s = list(s)
    s.sort(reverse=True)
    answer = ''
    for i in s:
        answer += i
    return answer

# 다른 사람 코드
def solution(s):
    answer = ''
    answer = ''.join(sorted(s,reverse=True))

    return answer