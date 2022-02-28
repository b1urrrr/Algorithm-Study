# 1부터 n까지 정수의 합 구하기(n은 양수만)

print('1부터 n까지 정수의 합을 구합니다.')

# 파이썬은 사후 판단 반복문을 지원하지 않는다
while True:
    n = int(input('n값을 입력하세요: '))
    if n > 0:
        break
sum = 0
i = 1

for i in range(1,n+1):
    sum += i
    i +=1
    
print(f'1부터 {n}까지의 정수의 합은 {sum}입니다.')