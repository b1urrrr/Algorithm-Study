# 내 코드
N = int(input())
sum = 0
i = 0

while N > sum:
    i+=1
    sum += i
      
sum = abs(sum-N-(i-1))

a=1
b=i
while sum >0:
    a+=1
    b-=1
    sum -=1
    
if i % 2 == 0:
    print(f'{a}/{b}')
else:
    print(f'{b}/{a}')

# 다른 사람 코드
n = int(input())

num = 0
bot = 0
while num < n:
    bot+=1
    num+=bot

iter = num - n
if bot%2 == 0:
    print('{0}/{1}'.format(bot-iter, 1+iter))
else:
    print('{0}/{1}'.format(1+iter, bot-iter))