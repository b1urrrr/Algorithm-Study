T = int(input())

for _ in range(T):
    R, S = input().split()
    P = str()  # 빈 문자열 객체 생성

    for i in range(len(S)):
        P += S[i]*int(R)

    print(P)
