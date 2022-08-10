# 수학
# 1312번: 소수
# 틀림 → 단순히 파이썬의 함수로 문자열 변환하는 건 X
a, b, n = map(int, input().split())
res = str(round(a/b,n+1))
print(res[-2])

# 실제로 나눗셈을 계속 반복하여 값을 반환해야 정답
a, b, n = map(int, input().split())
for i in range(n):
    a = (a%b)*10
    res = a//b
print(res)
