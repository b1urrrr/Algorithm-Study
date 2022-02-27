# 세 정수를 입력받아 중앙값 구하기 2
# 오히려 비효율적인 방법

def med3(a,b,c):
    """a, b, c의 중앙값을 구하여 반환 2"""
    if (b>=a and c <= a) or (b <=a and c >= a):
        return a
    elif (a > b and c < b) or (a < b and c > b):
        return b
    return c