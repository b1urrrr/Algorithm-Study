import sys
input = sys.stdin.readline
M = int(input())
N = int(input())
my_list = []
for num in range(M, N+1):
    error = 0
    if num > 1:
        for i in range(2, num):
            if num % i == 0 :
                error += 1
                break
        if error == 0 :
            my_list.append(num)
        
if len(my_list) > 0:
    print(sum(my_list))
    print(min(my_list))
else:
    print(-1)