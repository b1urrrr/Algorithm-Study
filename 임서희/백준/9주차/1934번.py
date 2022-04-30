# 시간 초과 났던 첫 번째 코드
def func(A,B):
    i = 2
    res = 1
    if A>=B:
        min = B
    else:
        min = A
    while A//i > 0 and B//i>0: # 값은 나오지만 이 while문 때문에 시간 초과가 나오는 것으로 추측
        if A%i==0 and B%i==0:
            A = A//i
            B = B//i
            res *= i
        else:
            i+=1
            if i > min:
                break
    res = res*A*B
    return res

T = int(input())

for _ in range(T):
    A, B = map(int, input().split())
    if A == 1:
        print(B)
    elif B==1:
        print(A)
    else:
        print(func(A,B))

def func(A,B):
    i = 2
    res = 1
    if A>=B:
        min = B
    else:
        min = A
    min_list = []

    for i in range(2, min+1): # 그래서 미리 min 값의 약수를 구해서
        if min %i ==0:
            min_list.append(i)

    for num in min_list[::-1]: # 약수 중 가장 큰 값부터 나누는 순으로 최소 공약수 구하기
        if A%num ==0 and B%num ==0:
            res *= num
            A//=num
            B//=num
    
    res = res*A*B # 남은 A, B까지 곱하면 최대 공배수
    return res 

T = int(input())

for _ in range(T):
    A, B = map(int, input().split())
    if A == 1:
        print(B)
    elif B==1:
        print(A)
    else:
        print(func(A,B))


# 유클리드 알고리즘 이용하기
# 유클리드 알고리즘이란?
# 두 수 사이에 존재하는 최대공약수(GCD: greatest common divisor)를 구하는 알고리즘

# 원리: a,b에 대해서(a>b) a를 b로 나눈 나머지를 r이라고 할 때, a와 b의 최대 공약수는 b와 r의 최대공약수와 같다.
# 임의의 값 a,b가 주어졌을 때 큰 값이 a라고 가정해보자.
# a를 b로 나눈 나머지가 n이라면 (a%b=n)
# n이 0이 될 때, b가 최대 공약수이다.
# n이 0이 아니라면, a에 b값을 다시 넣고 n을 b에 대입한 후 반복한다.

# 반복문
# 1.
def gcd(a,b):
    r = -1
    while b>0:
        r = a%b
        a = b
        b = r
    return a

# 2. 더 짧게
def gcd(a,b): 
    while a%b!=0: # a%b!=0이라서 return b (나머지가 0 되기 직전 값 return)
        a,b=b,a%b
    return b # 만약 b!=0이면 return a (나머지가 0이 된 값이 b가 되었으므로 a return)

# 재귀 호출
def gcd(a,b):
    # 파이썬 미지원 삼항 연산자
    # return b ? gcd(b,a%b):a
    # [조건] ? [true] : [false]
    
    # 파이썬 지원 삼항 연산자
    # [true] if [조건] else [false]
    return gcd(b,a%b) if b!=0 else a


# 따라서 유클리드 호제법을 이용한 코드
T = int(input())

for _ in range(T):
    a,b= map(int, input().split())
    aa,bb = a, b

    # 1.
    while bb != 0:
        aa,bb=bb,aa%bb
    
    print(a*b//aa) # 입력 값들을 곱하고 GCD로 나누면 최소 공배수 구하기
    # 입력 값 한 쪽에서 최대 공약수를 약분하게 되므로 

    # 혹은
    # 2.
    while a%b!=0: 
        a,b=b,a%b 
    print(aa*bb//b)
