# a부터 b까지 정수의 합 구하기(for 문)

print('a부터 b까지 정수의 합 구하기')
a = int(input('정수 a를 입력하세요: '))
b = int(input('정수 b를 입력하세요: '))

if a > b:
    a,b = b, a # a와 b를 오름차순 정렬
    
sum = 0
for i in range(a, b+1): # a 이상 b+1 미만
    sum += i
    
print(f'{a}부터 {b}까지 정수의 합은 {sum}입니다.')