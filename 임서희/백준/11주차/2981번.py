# 정수론 및 조합론
# 검문

#최대공약수를 빠르게 구해주는 유클리드 호제법
def gcd(x,y):
    mod = x % y
    while mod >0:
        x = y
        y = mod
        mod = x % y
    return y

#약수 리스트를 구해주는 함수
def div(x):
    div_list = [x]
    for i in range(2, int(x**(1/2) + 1)):
        if x % i == 0:
            div_list.append(i)
            if x//i != i:
                div_list.append(x//i) 
    div_list.sort()
    return div_list 
    
    
#입력함수
N = int(input())
freight = []
for _ in range(N):
    freight.append(int(input()))
freight.sort(reverse = True)


#화물들의 차이 입력
freight_diff = []
for i in range(len(freight)-1):
    freight_diff.append(freight[i] - freight[i+1])

#화물들의 차이를 최대공약수 함수를 이용해 구해주기
if len(freight_diff) == 1:
    answer = freight_diff[0]
elif len(freight_diff) == 2:
    answer = gcd(freight_diff[0], freight_diff[1])
else:
    answer = freight_diff[0]
    for i in range(1, len(freight_diff)):
        answer = gcd(answer, freight_diff[i]) 

#구한 최대공약수의 모든 약수 출력
for i in div(answer):
    print(i, end = ' ')