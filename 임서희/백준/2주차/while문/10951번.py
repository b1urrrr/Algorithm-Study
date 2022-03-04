# try~except를 사용하지 않으면 런타임 에러 발생!

while True:
    try:
        a, b = map(int, input().split())
        print(a+b)
    except:
        break
