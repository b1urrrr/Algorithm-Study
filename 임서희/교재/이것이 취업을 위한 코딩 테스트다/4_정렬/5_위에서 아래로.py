# 정렬 문제
# 위에서 아래로
n = int(input())
array = []

for i in range(n):
    a = int(input())
    array.append(a)

array.sort(reverse=True)

for a in array:
    print(a, end= ' ')

# 문제 답안
n = int(input())

array = []
for i in range(n):
    array.append(int(input()))

array = sorted(array, reverse=True)

for i in array:
    print(i, end = ' ')