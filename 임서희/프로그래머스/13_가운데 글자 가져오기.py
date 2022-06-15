# 연습 문제
# 레벨1: 가운데 글자 가져오기
def solution(s):
    length = len(s)//2
    if len(s) % 2 == 0:
        answer = s[length-1:length+1]
    else:
        answer = s[length]
    return answer