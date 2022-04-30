# 브루트 포스법으로 문자열 검색하기

def bf_match(text: str, pattern: str) -> int:
    # 브루트 포스법으로 문자열 검색
    pt = 0      # text를 따라가는 커서
    pp = 0      # pattern을 따라가는 커서

    while pt != len(text) and pp != len(pattern):
        if text[pt] == pattern[pp]:
            pt += 1
            pp += 1
        else:
            pt = pt - pp + 1
            pp = 0
    return pt - pp if pp == len(pattern) else -1

if __name__ == '__main__':
    s1 = input('텍스트 입력: ')
    s2 = input('패턴 입력: ')

    idx = bf_match(s1, s2)

    if idx == -1:
        print('텍스트 안에 패턴이 존재하지 않습니다.')
    else:
        print(f'{(idx+1)}번째 문자가 일치합니다.')