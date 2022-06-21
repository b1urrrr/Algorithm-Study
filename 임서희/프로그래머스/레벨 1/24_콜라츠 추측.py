# 연습 문제
# 콜라츠 추측
def solution(num):
    cnt = 1
    if num == 1:
        cnt = 0
    else:
        while cnt <= 500:
                if num % 2 == 0:
                    num //= 2
                else:
                    num = num*3 + 1
                if num == 1:
                    break    
                cnt += 1
    if cnt >= 500:
        cnt = -1
    return cnt


# 다른 사람 코드
def solution(num):
    if num != 1:
        for i in range(500):
            num = num / 2 if num % 2 == 0 else num * 3 + 1
            if num == 1:
                return i + 1
    else:
        return 0
    return -1