# +와 -를 번갈아 출력하기 2

print('+와 -를 번갈아 출력합니다.')

n = int(input('몇 개를 출력할까요?: '))

for _ in range(n//2): # +-를 n//2개 출력
    print('+-', end='')
    
if n%2:
    print('+',end='') # 홀수일 때 + 추가로 출력
    
print()