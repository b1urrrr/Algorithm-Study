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