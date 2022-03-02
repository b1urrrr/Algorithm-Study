# input()이 아닌 sys.stdin.readline()으로 입력 받기
import sys
T = int(input())

for i in range(T):
    a, b = map(int, sys.stdin.readline().split())
    print(f'{a+b}')
