# 내 코드: 68ms
while True:
    max_num = 0
    a,b,c = map(int, input().split())
    if a == b == c == 0:
        break
    max_num = max(a,b,c)
    if max_num == a:
        if b**2+c**2 == a**2:
            print('right')
        else:
            print('wrong')
    elif max_num == b:
        if a**2+c**2 == b**2:
            print('right')
        else:
            print('wrong')
    else:
        if a**2+b**2 == c**2:
            print('right')
        else:
            print('wrong')
            
# 다른 방법: 시간 64ms            
# list로 숫자 세개를 받아서 sorted 하고 0,1번 원소의 제곱 합과
# 2번째 인덱스 원소의 제곱이 같으면 right 출력
        