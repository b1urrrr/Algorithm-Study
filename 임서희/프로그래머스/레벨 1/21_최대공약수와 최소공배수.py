# 연습문제
# 레벨1: 최대공약수와 최소공배수
def solution(n, m):
    min_num = min(n,m)
    i = min_num
    gcd = 1
    while min_num != 1:
        if n%min_num == 0 and m%min_num == 0:
            gcd *= min_num
            n //= min_num
            m //= min_num
            min_num = min(n,m)
        else:
            min_num -= 1
    lcm = gcd * n * m
    return [gcd, lcm]

# 답은 맞았는데, 유클리드 호제법을 잊어서 다시 공부하기

#  다른 사람 코드 (유클리드 호제법)
def gcdlcm(a, b):
    c, d = max(a, b), min(a, b)
    t = 1
    while t > 0:
        t = c % d
        c, d = d, t
    answer = [c, int(a*b/c)]

    return answer