# 브루트포스
# 1527번: 금민수의 개수
# 내 코드: 실패
import sys
n, m = map(int, sys.stdin.readline.split())

while n <= m:
    n_list = list(str(n))
    if n_list[0] == '4' or n_list[0] == '7':
        break
    else:
        n+=1

num_list = ['0','1','2','3','5','6','8','9']
cnt = 0
for k in range(n, m+1):
    n_list = list(str(k))
    for i in num_list:
        if i in n_list:
            break
    else:
        cnt += 1
print(cnt)

# 다른 사람 코드
import sys
from itertools import product
input = sys.stdin.readline

a, b = map(int, input().split())
x = len(str(a))
y = len(str(b))

cnt = 0

for i in range(x, y+1):
    lst = list(product([4, 7], repeat=i))
    for num in lst:
        n = int(''.join(map(str, num)))
        if a <= n <= b:
            cnt += 1

print(cnt)