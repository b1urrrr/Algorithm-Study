# 1247번: 부호
import sys

num_list = []
for i in range(3):
    n = int(input())
    for _ in range(n):
        num_list.append(int(input()))
    
    sum_list = sum(sum_list)
    if sum_list == 0:
        print(0)
    elif sum_list < 0 :
        print('-')
    else:
        print('+')