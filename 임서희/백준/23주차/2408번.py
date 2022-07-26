# 수학, 구현
# 2408번: 큰 수 계산
# 파이썬 eval 함수 이용: 기본적으로 문자열로 된 수식을 input으로 받아 결과를 return 하는 함수
n = int(input())
n_list = ''
for _ in range(2*n-1):
    n_list += input()
n_list = n_list.replace('/','//')
print(eval(n_list))
