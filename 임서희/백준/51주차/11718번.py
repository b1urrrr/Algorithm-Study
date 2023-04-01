# 문자열
# 11718번: 그대로 출력하기

# 입력을 몇 번 받는지는 나와있지 않고, 최대 100줄 입력받을 수 있다는 조건만 존재
while True:
    try:
        print(input())
    except EOFError:   # 따라서 입력이 끝날 때 종료를 원할 때 EOFError 사용
        break