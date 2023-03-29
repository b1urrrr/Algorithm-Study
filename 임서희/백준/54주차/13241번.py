# 유클리드 호제법
# 13241번: 최소공배수

a, b = map(int, input().split())
res = a*b

while b:
    if a>b:
        a,b = b, a
    b%=a
print(res//a)