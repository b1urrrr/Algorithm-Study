# 코딩 테스트 입문
# 인덱스 바꾸기
# 내 코드
def solution(my_string, num1, num2):
    my_string_li = list(my_string)
    my_string_li[num1], my_string_li[num2] = my_string_li[num2], my_string_li[num1]
    res = ''
    for i in my_string_li:
        res += i
    return res
# 다른 사람 코드
def solution(my_string, num1, num2):
    s = list(my_string)
    s[num1],s[num2] = s[num2],s[num1]
    return ''.join(s)