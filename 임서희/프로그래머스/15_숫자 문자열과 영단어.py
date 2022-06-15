# 2021 카카오 채용연계형 인턴십
# 레벨1: 숫자 문자열과 영단어
# 걸린 시간: 5분
def solution(s):
    numbers = ['zero','one','two','three','four','five','six','seven','eight','nine']
    i = 0
    for number in numbers:
        if number in s:
            s = s.replace(number, str(i))
        i += 1
    return int(s)

# 다른 사람 코드 1
def solution(s):
    arr = ['zero', 'one', 'two', 'three', 'four', 'five', 'six', 'seven', 'eight', 'nine']

    for i in range(10):
        if (arr[i] in s):
            s = s.replace(arr[i], str(i))
    return int(s)

# 다른 사람 코드 2
def solution(s):
    dict={'0':'zero','1':'one','2':'two','3':'three','4':'four','5':'five','6':'six','7':'seven','8':'eight','9':'nine','10':'ten'}
    answer = 0
    answer = s
    for key, value in dict.items():
        answer= answer.replace(value, key)
    return int(answer)