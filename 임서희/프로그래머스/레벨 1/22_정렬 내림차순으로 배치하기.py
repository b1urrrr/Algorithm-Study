# 연습문제
# 레벨1: 정렬 내림차순으로 배치하기
def solution(n):
    n = list(str(n))
    n = sorted(n, reverse=True)
    answer=''
    for i in n:
        answer += i
    return int(answer)

# 다른 사람 코드
def solution(n):
    ls = list(str(n))
    ls.sort(reverse = True)
    return int("".join(ls))