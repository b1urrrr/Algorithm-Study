def d(n):
    n = n + sum(map(int, str(n)))  # 정수 n의 각 자릿수들의 합 구하기
    return n


noSelfNum = set()  # 중복 제거를 위해 set 사용

for i in range(1, 10001):
    noSelfNum.add(d(i))

# 셀프 넘버 출력
for j in range(1, 10001):
    if j not in noSelfNum:
        print(j)
