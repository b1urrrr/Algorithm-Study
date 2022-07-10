# 1009번: 분산처리
# 틀린 코드1: 시간 초과
n = int(input())
for _ in range(n):
    a, b = map(int, input().split())
    num = a**b
    num = num%10
    print(num)

# 틀린 코드2
import sys
n = int(sys.stdin.readline())
for _ in range(n):
    a, b = map(int, sys.stdin.readline().split())
    b = b%4
    num = a**b
    print(num%10)

# 지수승이 규칙적으로 변하는걸 이용하기
import sys 
input = sys.stdin.readline

t = int(input())
for _ in range(t):
	a,b = map(int,input().split())
	aa=a%10

	if aa == 0: # 패턴 1
		print(10)
	elif aa in [1,5,6]: 
		print(aa)
	elif aa in [4,9]: #패턴 2
		bb=b%2
		if bb == 0:
			print(aa*aa%10)
		else:
			print(aa)
	else: #패턴 4
		bb=b%4  
		if bb ==0:
			print(aa**4%10)
		else:
			print(aa**bb%10)