# 정렬, 구현
# 13771번: Presents
n = int(input())
li = []

for _ in range(n):
    li.append(float(input()))
    
li = sorted(li)
print("{:.2f}".format(float(li[1])))