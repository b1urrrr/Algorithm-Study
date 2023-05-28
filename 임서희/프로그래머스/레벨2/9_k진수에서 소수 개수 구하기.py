# 코딩테스트 연습
# 2022 KAKAO BLIND RECRUITMENT
# 레벨2: k진수에서 소수 개수 구하기

# 일부 실패: 테스트케이스 1,4,11,12,13 실패

# 110011을 10진수로 바꾼 예시에서 에러
# li = list(map(int, tmp.split('0')))
# ValueError: invalid literal for int() with base 10: ''
def solution(n, k):

    # 진수 바꾸기
    tmp = ''
    while n:
        tmp = str(n%k) + tmp
        n //= k

    li = list(map(int, tmp.split('0')))
    cnt = 0

    # 소수 확인하기
    for i in li:
        if i <= 1:
            continue
        prime = True
        for j in range(i-1, 2, -1):
            if i%j == 0:
                prime = False
                break
        if prime:
            cnt += 1
    print(cnt)
    return cnt