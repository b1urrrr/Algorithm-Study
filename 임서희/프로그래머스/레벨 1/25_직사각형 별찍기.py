# 연습 문제
# 직사각형 별 찍기
n,m = map(int, input().split())

for i in range(m):
    for j in range(n):
        print('*',end='')
    print()

# 다른 사람 코드 1
a, b = map(int, input().strip().split(' '))
answer = ('*'*a +'\n')*b
print(answer)

# 다른 사람 코드 2
a, b = map(int, input().strip().split(' '))
for _ in range(b):
    print('*'*a)