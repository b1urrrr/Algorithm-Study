# 구현
# 10430번: 나머지
A,B,C = map(int,input().split())

print((A+B)%C, ((A%C)+(B%C))%C, (A*B)%C, ((A%C)*(B%C))%C, sep='\n')