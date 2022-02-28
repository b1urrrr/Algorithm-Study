# +와 -를 번갈아 출력하기 1

print('+와 -를 번갈아 출력합니다.')

n = int(input('몇 개를 출력할까요?: '))

# 문제점
# 1. for문을 반복할 떄마다 if문 수행
# 2. 상황에 따라 유연하게 수정이 어려
for i in range(n):
    if i % 2: # 홀수일 경우 - 출력
        print('-', end='')
    else: # 짝수 일 경우 + 출력
        print('+', end="")
        
print()