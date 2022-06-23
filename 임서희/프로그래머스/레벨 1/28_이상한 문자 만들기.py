# 연습 문제
# 이상한 문자 만들기
# 틀린 코드: 6점
def solution(s):
    s = "    trydd    hello    world    "
    s.lower()
    copy_s = list(s)
    result = ''
    index = 0 # 짝수, 홀수 계산
    cnt = 0 
    for i in s:
        if i == " ":
            index = 0
            result += i
        else:
            if index % 2 == 0:
                result += copy_s[cnt].upper()
            else:
                result += i
            index += 1
        cnt += 1
    return result
    

# 틀린 코드: 31점
def solution(s):
    answer = list(s.split())
    result = ''
    for a in answer:
        for i in range(len(a)):
            if i%2 == 0:
                result += a[i].upper()
            else:
                result += a[i]
        result += ' '
    return result.strip()