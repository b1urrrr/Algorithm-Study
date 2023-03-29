# 연습 문제
# 레벨1: 연속된 수의 합
def solution(num, total):
    answer = []
    a = total//num
    if num % 2 == 1:
        answer = [a-i for i in range(num//2, 0, -1)] + [a] + [a+i for i in range(1, num//2+1)]
    else:
        answer = [a-i for i in range(num//2-1, 0, -1)] + [a] + [a+i for i in range(1, num//2+1)]
    return answer

# 다른 사람 코드
def solution(num, total):
    return [(total - (num * (num - 1) // 2)) // num + i for i in range(num)]