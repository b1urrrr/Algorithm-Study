def max3(a, b, c):
    """a,b,c의 최댓값을 구하여 반환"""
    maximum = a
    if b > maximum: maximum = b
    if c > maximum: maximum = c
    return maximum # 최댓값 반환

print(f'max3(3,2,1) = {max(3,2,1)}') # a>b>c
print(f'max3(3,2,2) = {max(3,2,2)}') # a>b=c
print(f'max3(3,1,2) = {max(3,1,2)}') # a>c>b
print(f'max3(3,2,3) = {max(3,2,3)}') # a=c>b