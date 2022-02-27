# 1부터 n까지 정수의 합 구하기 1(while문)

print('1부터 n까지 정수의 합 구하기')
n = int(input('n 값을 입력하세요: '))

sum = 0
i = 1

while i<=n:
    sum += i
    i += 1
    
print('1부터 {n}까지 정수의 합은 {sum} 입니다.')

# 참고로 반복문을 쓰지 않고 가우스 덧셈으로도 가능하다.
# sum = n * (n+1) // 2