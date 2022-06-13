# 레벨1
# 신규 아이디 추천
# 참고: 파이썬 import re 정규 표현식 공부하기

# 파이썬 문법 활용 필요
# https://velog.io/@djagmlrhks3/Algorithm-Programmers-%EC%8B%A0%EA%B7%9C-%EC%95%84%EC%9D%B4%EB%94%94-%EC%B6%94%EC%B2%9C-by-Python
def solution(new_id):
    new_id = new_id.lower() # 소문자 치환
    answer = ''
    # 2단계
    for i in new_id:
        if i.isalnum() or i in '-_.':
            answer += i
    # 3단계
    while '..' in answer:
        answer = answer.replace('..', '.')

    # 4단계
    answer = answer[1:] if answer[0] == '.' and len(answer) > 1 else answer
    answer = answer[:-1] if answer[-1] == '.' else answer

    # 5단계
    if len(answer) < 1:
        answer = 'a'
    # answer = 'a' if answer == '' else answer

    # 6단계
    if len(answer) >= 16:
        answer = answer[:15]
        if answer[-1] == '.':
            answer = answer[:-1]

    # 7단계
    if len(answer) <= 2:
        answer += answer[-1] * (3-len(answer))
    
    return answer