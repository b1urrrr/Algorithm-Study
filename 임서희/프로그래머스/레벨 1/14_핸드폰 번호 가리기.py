# 연습 문제
# 레벨1: 핸드폰 번호 가리기
def solution(phone_number):
    return phone_number.replace(phone_number[:-4],'*'*(len(phone_number)-4))

# 다른 사람 코드
def solution(phone_number):
    answer = ''
    answer='*'*(len(phone_number)-4)+phone_number[-4:]
    return answer