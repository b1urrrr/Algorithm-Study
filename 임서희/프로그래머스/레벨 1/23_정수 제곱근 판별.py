# 연습 문제
# 레벨1: 정수 제곱근 판별
# 내 코드
def solution(n):
    k = 1
    res = k*k
    while res <= n:
        if res == n:
            res = (k+1)*(k+1)
            break
        else: 
            k+=1
            res = k*k
    else:
        res = -1
    return res

# 다른 사람 코드 1
def solution(n):
    answer = 0
    if n**0.5 == int(n**0.5):
        answer = ((n**0.5)+1)**2
    else:
        answer = -1
    return answer

# 다른 사람 코드 2
import math

def solution(n):
    return pow(math.sqrt(n)+1, 2) if int(math.sqrt(n)) == math.sqrt(n) else -1


print("결과 : {}".format(solution(121)));