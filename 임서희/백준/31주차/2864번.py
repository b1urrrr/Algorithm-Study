# 그리디 알고리즘
# 2864번: 5와 6의 차이
# 내 코드
n1, n2 = map(int, input().split())
    
# 최솟값
def min_res(n):
    res = ''
    for i in str(n):
        if int(i) == 6:
            res += '5'
            continue
        res += str(i)
    return int(res)

# 최댓값
def max_res(n):
    res = ''
    for i in str(n):
        if int(i) == 5:
            res += '6'
            continue
        res += str(i)
    return int(res)

print(min_res(n1) + min_res(n2), max_res(n1) + max_res(n2))

# 다른 사람 코드
# replace 함수 이용
import sys

A,B = sys.stdin.readline().split()

min_A = A.replace('6','5')
max_A = A.replace('5','6')
min_B = B.replace('6','5')
max_B = B.replace('5','6')

print(int(min_A)+int(min_B),int(max_A)+int(max_B))