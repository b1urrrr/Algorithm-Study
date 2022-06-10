# 연습문제
# 서울에서 김서방 찾기 
# 1.
def solution(seoul):
    answer = ''
    id = 0
    for i in seoul:
        if i == "Kim":
            answer = '김서방은 ' + str(id) +'에 있다'
        id += 1 
    return answer

# 2. enumerate 이용
def solution(seoul):
    answer = ''
    for i,k in enumerate(seoul):
        if k == "Kim":
            answer = '김서방은 ' + str(i) +'에 있다'
    return answer