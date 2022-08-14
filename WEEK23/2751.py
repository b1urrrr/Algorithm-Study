import sys

N = int(sys.stdin.readline())
num = []

for _ in range(N):
    # num.append(int(input()))
    # 시간 초과로 아래의 코드 이용
    num.append(int(sys.stdin.readline()))

num.sort()
## 시간 초과를 피하기 위해 sort() 는 for 문 바깥에 작성해야함

for i in num:
    print(i)
