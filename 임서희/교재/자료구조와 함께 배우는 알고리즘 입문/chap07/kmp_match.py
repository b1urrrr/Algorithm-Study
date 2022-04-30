# KMP 법으로 문자열 검색하기
# 브루트 포스법과는 달리 KMP법에서 텍스트를 스캔하는 커서 pt는 앞으로 나아갈 뿐 뒤로 되돌아오지 않는다.

def kmp_match(text:str, pattern:str) -> int:
    # KMP법으로 문자열 검색
    pt = 1
    pp = 0
    skip = [0] * (len(pattern)+1)

    # 건너뛰기 표 만들기
    skip[pt] = 0
    while pt != len(pattern):
        if pattern[pt] == pattern[pp]:
            pt += 1
            pp += 1
            skip[pt] = pp
        elif pp == 0:
            pt += 1
            skip[pt] = pp
        else:
            pp = skip[pp]

    # 문자열 검색하기
    pt = pp = 0
    while pt != len(text) and pp != len(pattern):
        if text[pt] == pattern[pp]:
            pt += 1
            pp += 1
        elif pp == 0:
            pt += 1
        else:
            pp = skip[pp]
    
    return pt - pp if pp == len(pattern) else -1

if __name__ == '__main__':
    s1 = input('텍스트 입력: ')
    s2 = input('패턴 입력: ')

    idx = kmp_match(s1, s2)

    if idx == -1:
        print('텍스트 안에 패턴이 존재하지 않습니다.')
    else:
        print(f'{(idx+1)}번째 문자가 일치합니다.')