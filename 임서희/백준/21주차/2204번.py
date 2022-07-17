# 문자열/정렬
# 2204번: 도비의 난독증 테스트
while True:
    n = int(input())
    if n == 0:
        break
    alpha = []
    for i in range(n):
        alpha.append(input())
    alpha = sorted(alpha, key=lambda x:x.lower())
    print(alpha[0])
    