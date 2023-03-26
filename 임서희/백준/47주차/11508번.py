# 그리디 알고리즘
# 11508번: 2+1 세일

# 틀려서 다시 풀기
n = int(input())
you = []
for _ in range(n):
    you.append(int(input()))
you = sorted(you)
you_2 = [[] for _ in range(n//3+1)]
j = 0
res = 0
for i in range(n//3+1):
    you_2[i]= you[j:j+3]
    j+=3
    
for i in you_2:
    res += sum(i[1:3])

if n%3 == 0:
    print(res)
else:
    print(res+you_2[n//3][0])