from curses.ascii import isdigit
import sys
input = sys.stdin.readline ## t시간 초과를 막기 위해 사용
n, m = map(int, input().split())

dict = {}

for i in range(1, n+1):
    a = input().rstrip()
    dict[i] = a
    dict[a] = i

for i in range(m):
    quest = input().rstrip()
    if quest.isdigit(): # 숫자가 입력되면 이름 출력
        print(dict[int(quest)])
    else: #아니라면 숫자 출력
        print(dict[quest])
