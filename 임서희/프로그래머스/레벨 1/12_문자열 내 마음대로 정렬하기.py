# 연습문제
# 레벨1: 문자열 내 마음대로 정렬하기
def solution(strings, n):
    strings.sort(key=lambda x:(x[n],x))
    return strings

# 다른 사람 코드
def solution(strings, n):
    return sorted(sorted(strings), key=lambda x: x[n])