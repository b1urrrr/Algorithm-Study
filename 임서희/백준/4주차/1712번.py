# 시간 초과 나는 내 코드
A, B, C = map(int, input().split())
n = 1
try:
    while True:
        if A+B*n < C*n:
            print(n)
            break
        else:
            n+=1
            continue
except TimeoutError: # try-catch문을 써봐도 X
    print(-1)

# 수정 코드
A, B, C = map(int, input().split())
if B >= C:
    print(-1)
else:
    print(A//(C-B)+1)
           