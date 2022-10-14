# 정렬
# 11931번: 수 정렬하기 4
t = int(input())
li = []
for _ in range(t):
    li.append(int(input()))
li = sorted(li, reverse=True)
for i in li:
    print(i)