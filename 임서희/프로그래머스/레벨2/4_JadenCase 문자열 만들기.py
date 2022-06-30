# 연습문제
# 레벨2: JadenCase 문자열 만들기
# 참고: title(), capitalize() 내장 함수
def solution(s):
    s = list(s.lower())
    first = True
    result = ""
    for i in s:
        if i == " ":
            result += i
            first = True
        elif i != " " and first == True:
            result += i.upper()
            first = False
        else:
            result += i
    return result
    
    
# 다른 사람 코드
def solution(s):
    answer = ''
    s=s.lower()
    l=s.split(' ')
    for i in l:
        i= i.capitalize()
        answer+= i+" "
    #print(answer)
    return answer[:-1]